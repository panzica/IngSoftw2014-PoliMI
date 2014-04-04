package deadlock;

public class RisorsaA {
	private RisorsaB b;
	
	public void setB(RisorsaB b){
		this.b = b;
	}
	public synchronized void doA(String name){
		System.out.println("Hi, I'm " + name + " and doing A and then B()");
		b.doB(name);
	}
	
}
