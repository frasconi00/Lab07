package it.polito.tdp.poweroutages.model;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	private PowerOutageDAO podao;
	private List<PowerOutage> migliore;
	private int best;
	
	public Model() {
		podao = new PowerOutageDAO();
		this.migliore = new ArrayList<PowerOutage>();
		best=-1;
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public List<PowerOutage> analisi(int nercId, int anniMax, int oreMax) {
		
		List<PowerOutage> lista = this.podao.getPowerOutagesList(nercId);
		List<PowerOutage> parziale = new ArrayList<PowerOutage>();
		migliore.clear();
		best=-1;
		cerca(parziale,0,lista,lista.size(),anniMax,oreMax);
		
		return migliore;
		
	}
	
	/**
	 * 
	 * @param parziale lista dei po considerati
	 * @param livello rappresenta quale po stiamo considerando. Livello 0: primo po
	 * @param lista è la lista di tutti i po
	 * @param listaSize lunghezza della lista di po
	 */
	private void cerca(List<PowerOutage> parziale, int livello, List<PowerOutage> lista, int listaSize, int anniMax, int oreMax) {
		
		//casi terminali
		
		if(!controlloAnni(parziale,anniMax)) {
			return;
		}
		
		int ore = contaOre(parziale);
		
		if(ore>oreMax)
			return;
		
		else {
			//potenzialmente una soluzione
			int personeCoinvolte = contaPersoneCoinvolte(parziale);
			if(personeCoinvolte>best) {
				this.migliore = new ArrayList<PowerOutage>(parziale);
				this.best=personeCoinvolte;
			}
		}
		
		if(livello==listaSize)
			return;
		
		parziale.add(lista.get(livello));
		cerca(parziale,livello+1,lista,listaSize,anniMax,oreMax);
		
		parziale.remove(lista.get(livello));
		cerca(parziale,livello+1,lista,listaSize,anniMax,oreMax);
		
		
	}

	public int contaPersoneCoinvolte(List<PowerOutage> parziale) {
		int personeCoinvolte = 0;
		if(parziale.size()==0)
			return 0;
		
		for(PowerOutage p : parziale)
			personeCoinvolte+=p.getCustomersAffected();
		
		return personeCoinvolte;
	}

	public int contaOre(List<PowerOutage> parziale) {
		int ore = 0;
		for(PowerOutage p : parziale) {
			ore+=p.getDateEventBegan().until(p.getDateEventFinished(), ChronoUnit.HOURS);
		}
		return ore;
	}

	private boolean controlloAnni(List<PowerOutage> parziale, int anniMax) {
		
		if(parziale.size()==0 || parziale.size()==1)
			return true;
		
		int anno1 = parziale.get(0).getDateEventBegan().getYear();
		int anno2 = parziale.get(parziale.size()-1).getDateEventBegan().getYear();
		
		if(Math.abs(anno1-anno2)<=anniMax)
			return true;
		else
			return false;
	}

}
