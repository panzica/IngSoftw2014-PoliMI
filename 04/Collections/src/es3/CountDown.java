package es3;

import java.util.LinkedList;
import java.util.Queue;

public class CountDown {
	private Queue<Integer> countDown;
	private final int time;
	public CountDown(int time){
		countDown = new LinkedList<Integer>();
		this.time = time;
	}
	public void start(){
		for (int i = time; i >= 0; i --)
			countDown.add(i);
		while (!countDown.isEmpty()){				
			System.out.println(countDown.poll());
			
			try {				
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		CountDown cd = new CountDown(10);
		cd.start();
	}

	
}
