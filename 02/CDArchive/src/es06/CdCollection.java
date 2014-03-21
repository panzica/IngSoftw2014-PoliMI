package es06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CdCollection {
	private List <Cd> archivio;	
	public CdCollection (){
		archivio = new ArrayList<>();		
	}
	
	public void inserisciCD(Cd cd){
		archivio.add(cd);
	}
	
	public void stampaCollection(){
		for (Cd cd: archivio){			
				System.out.println(cd);
		}
	}
	
	public void sortCollection() {
		Collections.sort(archivio);
	}

}
