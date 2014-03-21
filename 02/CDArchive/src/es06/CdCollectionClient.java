package es06;

import java.util.Scanner;

public class CdCollectionClient {

	private static void printMenu(){
		System.out.println("CD Collection Menu"); 
		System.out.println("[1]: Inserisci CD"); 
		System.out.println("[2]: Mostra CD"); 
		System.out.println("[3]: Ordina per titolo"); 
		System.out.println("[4]: Exit");
	}
	public static void main(String[] args){
		CdCollection collection = new CdCollection();
		Scanner sc = new Scanner(System.in);
		int scelta = 4;
		do {
			
			printMenu();
			scelta = Integer.parseInt(sc.nextLine());				
			performScelta(sc,collection, scelta);			
		}while (scelta != 4);
		sc.close();
	}
	private static void performScelta(Scanner sc, CdCollection collection, int scelta) {
		switch (scelta){
		case 1:
			inserisciCD(sc,collection);
			break;
		case 2:
			collection.stampaCollection();
			break;
		case 3:
			collection.sortCollection();
			break;
		default:
			break;
		}		
	}
	
	private static void inserisciCD(Scanner sc, CdCollection collection){
		
		System.out.println("Inserisci titolo:");		
		String titolo = sc.nextLine();
		System.out.println("Inserisci autore:");		
		String autore = sc.nextLine();
		System.out.println("Inserisci prezzo:");		
		float prezzo = Float.parseFloat(sc.nextLine());
		
		System.out.println("Inserisci Giudizio (da 0 a 4):");		
		int valoreGiudizio = Integer.parseInt(sc.nextLine());
		
		Giudizio giudizio = Giudizio.values()[valoreGiudizio];
		collection.inserisciCD(new Cd(titolo, autore, prezzo, giudizio));
		
	}
}
