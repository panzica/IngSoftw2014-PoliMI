package singleton;
/**
 * Soluzione 1: metodo getInstance Synchronized
 * @author valerio
 *
 */
public class SynchronizedLazySingleton {
	private static SynchronizedLazySingleton uniqueInstance;
	
	private SynchronizedLazySingleton(){
		// costruttore
	}
	
	// metodi synchronized possono essere inefficienti
	public static synchronized SynchronizedLazySingleton getInstance(){
		if (uniqueInstance == null){
			uniqueInstance = new SynchronizedLazySingleton();
		}
		return uniqueInstance;
			
	}

}
