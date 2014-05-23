package decorator;

public class Whip extends CoffeeDecorator {

	public Whip(Coffee decoratedCoffee) {
		super(decoratedCoffee);	
	}	
	
	@Override
	public String ingredients(){
		return "Whip " + super.ingredients();
	}
	
	@Override
	public float getCost() {
		return super.getCost() + .5f;
	}

}
