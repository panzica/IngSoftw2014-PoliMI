package es1.robot;

import java.util.Collection;


public class Piatto {

	private Collection<Ingrediente> ingredienti;
	private boolean cooked;

	public Piatto(Collection<Ingrediente> ricetta) {
		ingredienti = ricetta;
	}
	
	public void setCooked(){
		cooked = true;
	}
	
	public boolean isCooked(){
		return cooked;
	}
	
	public Collection<Ingrediente> getIngredienti(){
		return ingredienti;
	}

}
