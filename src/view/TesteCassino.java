package view;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import controller.CassinoController;


public class TesteCassino {

	public static void main(String[] args) {
		
		ArrayList<String> nomes = new ArrayList<String>();
		nomes.add("KARINE");
		nomes.add("ADRIANO");
		nomes.add("ALICIA");
		nomes.add("GUSTAVO");
		nomes.add("LEONARDO");
		nomes.add("ROBERTO");
		nomes.add("HERNIQUE");
		nomes.add("GABRIEL");
		nomes.add("RODRIGO");
		nomes.add("MARCELLE");
	
	Semaphore semaforo = new Semaphore(1);
		
		for (int i = 0; i < 10; i++) {
			
			Thread cru = new CassinoController(nomes.get(i), semaforo);
			
			
		}

	}

}