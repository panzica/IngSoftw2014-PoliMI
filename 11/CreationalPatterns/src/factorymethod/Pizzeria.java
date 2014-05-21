package factorymethod;

public abstract class Pizzeria {
	public Pizza ordinaPizza(String tipo){
		Pizza pizza;
		pizza = creaPizza(tipo);
		pizza.prepara();
		pizza.cuoci();
		pizza.confeziona();
		
		return pizza;
	}
	
	protected abstract Pizza creaPizza(String tipo);
}
