package abstractfactory;

public class NapoliPizzaIngredientFactory implements PizzaIngredientFactory{

	@Override
	public Impasto creaImpasto() {
		Impasto impasto = new ImpastoSoffice();
		
		return impasto;
	}

	@Override
	public Salsa creaSalsa() {
		
		return new SalsaDellaNonna();
	}

	@Override
	public Formaggio creaFormaggio() {
		return new MozzarellaDiBufala();
	}



}
