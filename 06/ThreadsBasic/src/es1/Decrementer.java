package es1;

public class Decrementer implements Runnable{
	private ClasseClient client;
	
	public Decrementer(ClasseClient client){
		this.client = client;
	}
	
	@Override
	public void run(){
		client.decrement();
		System.out.println("I'm Decrementer, value " + client.value());
	}
}
