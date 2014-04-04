package synchcounter;

public class NONSynchronizedCounter implements Counter{
	private int c;
	@Override
	public void increment() {	
		System.out.println("NON synchronized version, Incrementing");		
		expensiveJob();
		c++;
	}

	@Override
	public void decrement() {
		c--;
		
	}

	@Override
	public int value() {	
		System.out.println("NON Synchronized Version, getting value");
		return c;
	}

	private void expensiveJob(){
		Pi.computePi(5000);
	}
}
