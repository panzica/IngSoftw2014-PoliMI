package es1.robot;

import java.util.Collection;
import java.util.Random;

public class RobotCuoco extends Robot {
	public Piatto cucina(Collection<Ingrediente> ricetta, Collection<Ingrediente> dispensa)
			throws IngredienteMancanteException{
		for(Ingrediente ingr : ricetta){
			if (!dispensa.contains(ingr)){
				//non dipende da me la inoltro al client
				throw new IngredienteMancanteException(ingr);
			}			
			/* TODO gestire il caso in cui un ingrediente 
			 e' presente in dispensa ma non nella giusta quantita'*/ 
		}
		Piatto piatto = new Piatto(ricetta);
		
		// dipende da me: so gestirla
		// esempio di gestione: riparare e ripetere l'operazione
		while (!piatto.isCooked()){
			try{
				cuoci(piatto);
			}
			catch(CotturaException e){
				riparaForno();				
			}
		}
		return piatto;
		
	}
	
	private void cuoci(Piatto p) throws CotturaException{
		Random rnd = new Random();
		int cookingResult = rnd.nextInt(3);
		if (cookingResult == 1){
			throw new CotturaException();
		}
		else {
			p.setCooked();
		}
		
	}
	
	private void riparaForno(){
		// TODO arrichire l'implementazione
	}

}
