package cosastampa;

public class CosaStampaOne {

	public static void f() throws Exception{ 
		System.out.println("Throw new Exception in f()");
		throw new Exception("Generated in f()"); 

	}
	public static void g() throws Exception{
		try {
			f();
		} 
		catch (Exception ex) {
			System.out.println("Exception catched in g(). Rethrow");
			throw ex; 
		}
	}

	public static void main(String[] args){ 
		try {
			g();
		} 
		catch (Exception ex) {
			System.out.println("Exception catched in main(). Just stay");
			System.out.println(ex.getMessage()); 
		}
	}

}
