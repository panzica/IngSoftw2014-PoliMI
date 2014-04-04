package synchcounter;

public class Incrementer implements Runnable{
	private Counter c;
	public Incrementer(Counter counter){
		this.c = counter;
	}
	@Override
	public void run(){
		c.increment();			
	}

}
