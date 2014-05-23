package decorator;

public abstract class CoffeeDecorator implements Coffee{
	private final Coffee decoratedCoffee;
	public CoffeeDecorator (Coffee decoratedCoffee){
		this.decoratedCoffee = decoratedCoffee;
	}
	@Override
	public String ingredients(){
		return decoratedCoffee.ingredients();
	}
	@Override
	public float getCost(){
		return decoratedCoffee.getCost();
	}
}
