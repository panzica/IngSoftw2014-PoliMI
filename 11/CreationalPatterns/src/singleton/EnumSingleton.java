package singleton;
/**
 * Metodo alternativo e thread safe. Non supporta ereditarieta'
 * @author valerio
 *
 */
public enum EnumSingleton {
	INSTANCE;
	public static EnumSingleton getInstance(){
		return INSTANCE;
	}
}
