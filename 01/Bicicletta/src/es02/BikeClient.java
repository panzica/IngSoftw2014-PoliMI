package es02;

public class BikeClient {
	public static void main(String[] args){
		// crea un oggetto Bike utilizzo il costruttore di default
		Bike b1 = new Bike();
		// modifico lo stato dell'oggetto tramite metodi
		b1.changeCadence(2);
		b1.incrementGear();
		b1.incrementGear();
		b1.printState();
		b1.brake();
		System.out.println("The speed now is "+ b1.getSpeed());
		
		// Es 2.1 Creazione oggetto con costruttore definito
		System.out.println("Creating a new object b2");
		Bike b2 = new Bike(3,10,20);
		System.out.println("The initial speed of b2 is: " + b2.getSpeed());
		
		// Es 2.2 Creazione di due oggetti DIVERSI
		Bike b3 = new Bike(3,10,20);
		Bike b4 = new Bike(3,10,20);
		System.out.println("b3 e b4 sono uguali? " + b3.equals(b4));
	}

}
