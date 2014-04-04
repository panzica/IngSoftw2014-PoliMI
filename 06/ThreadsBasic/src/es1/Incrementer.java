package es1;

public class Incrementer implements Runnable{
	private ClasseClient client;
	
	public Incrementer(ClasseClient client){
		this.client = client;
	}
	@Override
	public void run(){
		client.increment();
		System.out.println("Sono Incrementer, value: "+client.value());
	}

}
