package synchcounter;

public class ValueGetter implements Runnable{
	
	private Counter c;
	public ValueGetter(Counter c){
		this.c = c;
	}
	@Override
	public void run(){
		System.out.println("ValueGetter, value:" + c.value());		
	}

}
