package deadlock;

public class RisorsaB {
	private RisorsaA a;

	public void setA(RisorsaA a){
		this.a = a;
	}
	public synchronized void doB(String name){
		System.out.println("Hi, I'm " + name + " and doing B and then A()");
		a.doA(name);
	}

}
