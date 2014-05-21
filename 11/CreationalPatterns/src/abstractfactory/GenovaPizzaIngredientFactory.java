package abstractfactory;

public class GenovaPizzaIngredientFactory implements PizzaIngredientFactory{

	@Override
	public Impasto creaImpasto() {
		Impasto impasto = new ImpastoCroccante();
		System.out.println("Creo impasto " + impasto);
		return impasto;
	}

	@Override
	public Salsa creaSalsa() {
		Salsa salsa = new SalsaAlPesto();
		System.out.println("Creo salsa " + salsa);
		return salsa;
	}

	@Override
	public Formaggio creaFormaggio() {
		Formaggio formaggio = new Fiordilatte();
		System.out.println("Creo Formaggio " + formaggio);
		return new Fiordilatte();
	}



}
