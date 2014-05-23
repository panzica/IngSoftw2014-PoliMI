package decorator;
// classe base senza nessuna decorazione
public class SimpleCoffee implements Coffee{

	@Override
	public String ingredients() {
		
		return "coffee";
	}

	@Override
	public float getCost() {		
		return 1;
	}

}
