package abstractfactory;

public class PizzeriaCinqueTerre extends Pizzeria{

	PizzaIngredientFactory genovaFactory = new GenovaPizzaIngredientFactory();
	@Override
	public Pizza creaPizza(String tipo) {
		if (tipo.equals("margherita")){
			Pizza pizza = new PizzaMargherita(genovaFactory);
			pizza.setNome("Margherita Genovese");
			return pizza;
		}
		return null;
	}

}
