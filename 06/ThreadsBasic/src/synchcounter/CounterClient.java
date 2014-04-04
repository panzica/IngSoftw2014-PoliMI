package synchcounter;

public class CounterClient {
	public static void main(String[] args){
		
		Counter nonSyncCounter = new NONSynchronizedCounter();
		startThreads(nonSyncCounter);
		Counter syncCounter = new SynchronizedCounter();
		startThreads(syncCounter);
		
	}
	private static void startThreads(Counter c){
		Thread t1 = new Thread(new Incrementer(c));
		Thread t2 = new Thread(new ValueGetter(c));
		t1.start();
		t2.start();
	}

}
