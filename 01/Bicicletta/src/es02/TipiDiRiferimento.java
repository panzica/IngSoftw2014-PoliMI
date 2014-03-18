package es02;

// Es 2.3 cosa stampa?
public class TipiDiRiferimento {
	public static void main(String [] args){
		Bike b1 = new Bike(2,10,4);
		Bike b2 = b1;
		System.out.println("b1 e b2 sono uguali? " + b1.equals(b2) );
		System.out.println("b1 e b2 sono lo stesso oggetto? " + (b1 == b2));
		// stampo lo stato di b1
		b1.printState();
		// stampo lo stato di b2
		b2.printState();
		// incremento la marcia di b2
		b2.incrementGear();
		// stampo lo stato di b1
		b1.printState();		
	}
}
