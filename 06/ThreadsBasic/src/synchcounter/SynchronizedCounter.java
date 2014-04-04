package synchcounter;

public class SynchronizedCounter implements Counter{
	private int c;
	
	@Override
	public synchronized void increment(){
		System.out.println("Synchronized Version, Incrementing");
		
		expensiveJob();
		c++;
		
	}
	@Override
	public synchronized void decrement(){
		c--;
	}
	@Override
	public synchronized int value(){
		System.out.println("Synchronized Version, getting value");
		return c;
	}
	
	private void expensiveJob(){
		Pi.computePi(5000);
	}
	
}
