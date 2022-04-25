package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import it.polito.tdp.poweroutages.model.PowerOutage;

public class TestPowerOutagesDAO {

	public static void main(String[] args) {
		
		try {
			Connection connection = ConnectDB.getConnection();
			connection.close();
			System.out.println("Connection Test PASSED");
			
			PowerOutageDAO dao = new PowerOutageDAO() ;
			
			System.out.println(dao.getNercList()) ;
			System.out.println(dao.getPowerOutagesList(3));
			List<PowerOutage> lista = dao.getPowerOutagesList(3);
			
			LocalDateTime t1 = lista.get(0).getDateEventBegan();
			LocalDateTime t2 = lista.get(0).getDateEventFinished();
			double ore = t1.until(t2, ChronoUnit.HOURS);
			
			System.out.println("\n\n"+lista.get(0));
			System.out.println(ore);

		} catch (Exception e) {
			System.err.println("Test FAILED");
		}

	}

}
