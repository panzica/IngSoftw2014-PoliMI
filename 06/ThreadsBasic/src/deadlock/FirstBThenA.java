package deadlock;

public class FirstBThenA extends Thread {
	private String name;	
	private RisorsaB b;
	
	public FirstBThenA(String name, RisorsaB b){
		this.name = name; 		
		this.b = b;
	}
	@Override
	public void run(){
		b.doB(name);		
	}


}
