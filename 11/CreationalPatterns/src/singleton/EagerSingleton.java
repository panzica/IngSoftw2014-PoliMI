package singleton;
/**
 * Metodo 2: Creare l'istanza in uno static initializer. Automaticamente thread safe.
 * @author valerio
 *
 */
public class EagerSingleton {
	// se l'oggetto e' molto grande puo' occupare memoria inutile se mai utilizzato
	private static EagerSingleton uniqueInstance = new EagerSingleton();
	private EagerSingleton(){
		
	}
	public static EagerSingleton getInstance(){
		// siamo sicuri che uniqueInstance e' gia' inizializzata e thread-safe
		return uniqueInstance;
	}

}
