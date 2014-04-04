package es1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ClasseClient {
	private int value;
	public synchronized void increment(){
		value++;
	}
	public synchronized void decrement(){
		value--;
	}
	public synchronized int value(){
		return value;
	}
	
	public static void main(String[] args){
		ClasseClient client = new ClasseClient();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++){
			executor.submit(new Incrementer(client));
			executor.submit(new Decrementer(client));
		}
		executor.shutdown();
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			System.err.println("awaitTermination Failed");
		}
		System.out.println("Fatto!");
		
	}

}
