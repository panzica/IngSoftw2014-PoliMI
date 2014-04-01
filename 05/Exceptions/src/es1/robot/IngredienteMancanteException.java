package es1.robot;

public class IngredienteMancanteException extends Exception {
	private Ingrediente ingr;
	public IngredienteMancanteException(Ingrediente ingr){
		this.ingr= new Ingrediente(ingr.getNome(), ingr.getQuantita());
	}
	public Ingrediente getIngr(){
		return ingr;
	}
}
