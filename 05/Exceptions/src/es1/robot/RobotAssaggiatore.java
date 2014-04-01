package es1.robot;

import java.util.Random;

public class RobotAssaggiatore extends Robot{
	public boolean assaggia(Piatto p){
		// Stile ask for permission
		if (p != null){					
			try{
				//tempo per assaggiare
				Thread.sleep(1000);
			}
			catch(InterruptedException ex){
				// non ho assaggiato abbastanza
				return false;
			}
			return tiPiace(p);
		}
		else {
			// non posso assagiare un piatto null
			return false;
		}
		
	}
	
	private boolean tiPiace(Piatto p){
		/* qui niente eccezioni :
		se non piace non e' un errore
		*/ 
		return new Random().nextBoolean(); 
	}

}
