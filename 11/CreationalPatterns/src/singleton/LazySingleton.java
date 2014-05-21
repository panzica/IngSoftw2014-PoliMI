package singleton;

/***
 * NB: Implementazione ERRATA per applicazioni multithreads
 * Puo' creare due istanze diverse
 * @author valerio
 *
 */
public class LazySingleton {
	private static LazySingleton uniqueInstance;
	// altri attributi
	
	private LazySingleton() {
		// costruttore
		// inizializzazione di altri attributi
		
	}
	public static LazySingleton getInstance(){
		if (uniqueInstance == null){
			uniqueInstance = new LazySingleton();
		}
		return uniqueInstance;
	}

}
