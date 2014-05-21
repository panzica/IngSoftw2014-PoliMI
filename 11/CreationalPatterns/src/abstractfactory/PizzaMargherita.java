package abstractfactory;

public class PizzaMargherita extends Pizza{

	public PizzaMargherita(PizzaIngredientFactory ingredientFactory) {
		super(ingredientFactory);
		
	}

	@Override
	public void prepara() {
		System.out.println("Preparando la pizza " + nome);
		impasto = ingredientFactory.creaImpasto();
		salsa = ingredientFactory.creaSalsa();
		formaggio = ingredientFactory.creaFormaggio();
		
		
	}

}
