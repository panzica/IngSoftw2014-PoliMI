package deadlock;

public class FirstAThenB extends Thread{
	private String name;
	private RisorsaA a;
	
	public FirstAThenB(String name, RisorsaA a){
		this.name = name; 
		this.a = a;
	}
	@Override
	public void run(){
		a.doA(name);
	}

}
