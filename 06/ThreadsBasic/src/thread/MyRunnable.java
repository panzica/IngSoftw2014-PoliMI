package thread;

public class MyRunnable implements Runnable{
	private String message;
	
	public MyRunnable(String message){
		this.message = message;
	}
	@Override
	public void run() {
		for (int i = 0; i < 9000; i++)
			System.out.println(message);	
	}
	
	public static void main(String[] args){
		Runnable r1 = new MyRunnable("on Thread 1");
		Runnable r2 = new MyRunnable("on Thread 2");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}

}
