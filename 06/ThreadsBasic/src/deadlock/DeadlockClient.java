package deadlock;

public class DeadlockClient {
	public static void main(String[] args ){
		RisorsaA a = new RisorsaA(); 
		RisorsaB b = new RisorsaB();
		a.setB(b);
		b.setA(a);		
		
		FirstAThenB tAB = new FirstAThenB("tAB", a);
		FirstBThenA tBA = new FirstBThenA("tBA", b);
		tAB.start();
		tBA.start();
		
	}

}
