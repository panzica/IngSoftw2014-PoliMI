package cosastampa;

public class MyException extends Exception {

	private static final long serialVersionUID = 4763341649803918490L;
	
	public MyException(String message){
		super("This is an instance of MyException " + message);
	}
}
