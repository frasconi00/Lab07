package it.polito.tdp.poweroutages.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		//System.out.println(model.getNercList());
		
		List<PowerOutage> lista = model.analisi(3, 4, 200);
		for(PowerOutage po : lista) {
			System.out.println(po+"\n");
		}
		System.out.println("\n"+model.contaPersoneCoinvolte(lista)+" "+model.contaOre(lista));
	}

}
