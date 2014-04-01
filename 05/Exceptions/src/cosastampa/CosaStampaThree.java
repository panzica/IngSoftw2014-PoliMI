package cosastampa;

public class CosaStampaThree {
	public static void f() throws Exception { 
		System.out.println("Throw new Exception in f()");
		throw new Exception("Generated in f()"); 
	}
	public static void g() throws Exception { 
		try {
			f();
		} 
		catch (Exception ex) {
			System.out.println("Exception catched in g(). Rethrow");
			//utilizzo un altro costruttore che specifica la causa
			throw new Exception("Generated in g()",ex); 
		}
	}
	public static void main(String[] args) { 
		try {
			g();
		} 
		catch (Exception ex) {
			System.out.println("Exception catched in main(). Just stay");
			System.out.println(ex.getMessage() + " because of " 
			+ ex.getCause().getMessage()); 
		}
	}

}
