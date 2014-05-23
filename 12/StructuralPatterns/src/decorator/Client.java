package decorator;

public class Client {
	
	public static void main(String args[]) {
	     Coffee coffe = new SimpleCoffee();
	     Coffee decoratedCoffee = new Whip(coffe);
	     System.out.println("coffee: " + decoratedCoffee.ingredients());
	     System.out.println("cost: " + decoratedCoffee.getCost());  
	     
	     decoratedCoffee = new Cocoa(decoratedCoffee);
	     System.out.println("coffee: " + decoratedCoffee.ingredients());
	     System.out.println("cost: " + decoratedCoffee.getCost());  
	}
	
}
