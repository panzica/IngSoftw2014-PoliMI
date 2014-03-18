package es02;


public class Bike {
	// definizione di costanti
	private static final int MAX_GEAR = 18;
	private static final int MIN_GEAR = 1;
	
	// gli attributi definiscono lo stato della bicicletta;
	private int gear = 1; //default 1
	private int cadence; //default 0
	private int speed; //default 0
	
	//Es 2.2 Modifica: 
	private int id; //aggiungo un attributo per l'id
	//aggiungo un attributo di classe per contare gli id
	private static int idCounter; 
	
	// Es 2.1 Modifica: creazione di un costruttore
	public Bike(int gear, int speed, int cadence ){
		this(); // Es 2.2 aggiungo il cotruttore di default nella prima riga
		this.gear = gear;
		this.speed = speed;
		this.cadence = cadence;		
	}
	// Es 2.1 Modifica: aggiungo costruttore di default vuoto
	public Bike(){
		//Es 2.2 assegno l'id univocamente incrementando idCounter 
		id = idCounter++;
	}

	//i metodi definiscono le funzionalita'	
	public void changeCadence(int cadence){
		this.cadence = cadence;
		updateSpeed();
	}
	
	public void incrementGear(){
		if (gear < MAX_GEAR){
			gear++;
			updateSpeed();
		}
	}
	
	public void decrementGear(){
		if (gear > MIN_GEAR){
			gear--;
			updateSpeed();
		}
	}
	
	// ogni volta che cambia la cadence o la gear aggiorno la velocita'
	// questo e' un metodo privato e non invocabile dall'esterno
	private void updateSpeed(){
		speed = gear * cadence; 
	}
	
	public int getGear(){
		return gear;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public int getCadence(){
		return cadence;
	}
	
	public void brake(){
		speed = 0;
	}
	public void printState(){
		System.out.println("gear: "+ gear + ", speed: "+speed+ ", cadence: "+cadence);
	}
	
	// Es 2.2 aggiungo il metodo equals
	@Override //aggiungo annotazione
	public boolean equals(Object o){
		Bike other = (Bike) o; //casting necessario per accedere a id
		return other.id == this.id;
	}

}
