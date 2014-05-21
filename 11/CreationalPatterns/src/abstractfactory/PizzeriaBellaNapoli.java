package abstractfactory;

public class PizzeriaBellaNapoli extends Pizzeria{

	PizzaIngredientFactory napoliFactory = new NapoliPizzaIngredientFactory();
	@Override
	public Pizza creaPizza(String tipo) {
		if (tipo.equals("margherita")){
			Pizza pizza = new PizzaMargherita(napoliFactory);
			pizza.setNome("Margherita Napoletana");
			return pizza;
		}
		return null;
	}

}
