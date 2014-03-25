package myStack;

import java.util.Collection;

public interface MyStack <E>{
	public E pop();
	public void push(E elem);
	public boolean isEmpty();
	public int size();
	public boolean contains(E elem);
	public boolean containsAll(Collection<? extends E> collection);

	

}
