package factorymethod;

public class PizzeriaCinqueTerre extends Pizzeria{

	@Override
	public Pizza creaPizza(String tipo) {
		switch(tipo){
			case "pesto":
				return new PizzaGenovese();
			case "olive":
				return new PizzaTaggiasca();					
		}
		return null;
		
	}

}
