package abstractfactory;

public interface PizzaIngredientFactory {
	public Impasto creaImpasto();
	public Salsa creaSalsa();
	public Formaggio creaFormaggio();

}
