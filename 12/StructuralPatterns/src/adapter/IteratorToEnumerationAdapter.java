package adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorToEnumerationAdapter<T> implements Enumeration<T>{
	Iterator<T> iterator;

	public IteratorToEnumerationAdapter(Iterator<T> iterator){
		this.iterator = iterator;
	}
	@Override
	public boolean hasMoreElements() {		
		return iterator.hasNext();
	}

	@Override
	public T nextElement() {		
		return iterator.next();
	}
	

}
