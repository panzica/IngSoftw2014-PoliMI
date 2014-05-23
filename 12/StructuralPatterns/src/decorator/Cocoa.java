package decorator;

public class Cocoa extends CoffeeDecorator{
	public Cocoa(Coffee decoratedCoffee){
		super(decoratedCoffee);
	}
	
	@Override
	public String ingredients(){
		return "Cocoa " + super.ingredients();
	}
	
	@Override
	public float getCost(){
		return super.getCost() + .3f;
	}
	
	
	

}
