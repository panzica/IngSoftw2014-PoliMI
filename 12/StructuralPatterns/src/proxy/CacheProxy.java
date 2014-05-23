package proxy;

import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements ApplicationInterface{
	private Map<Object,Object> cache;
	private ApplicationInterface application;
	public CacheProxy(ApplicationInterface application){
		this.application = application;
		cache = new HashMap<>();
	}
	
	@Override
	public Object performOperation(Object parameter) {
		if (!cache.containsKey(parameter)){
			cache.put(parameter, application.performOperation(parameter));
		}
		return cache.get(parameter);
	}

}
