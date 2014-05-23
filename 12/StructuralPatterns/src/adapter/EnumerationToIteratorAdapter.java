package adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationToIteratorAdapter<T> implements Iterator<T>{

	private Enumeration<T> enumeration;
	public EnumerationToIteratorAdapter(Enumeration<T> enumeration){
		this.enumeration = enumeration;
	}
	@Override
	public boolean hasNext() {		
		return enumeration.hasMoreElements();
	}

	@Override
	public T next() {		
		return enumeration.nextElement();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
		
	}

}
