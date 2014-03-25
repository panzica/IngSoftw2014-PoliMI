package myStack;

import java.util.Collection;

public class LinkedListStack<E> implements MyStack<E>{
	private int N;
	private Node<E> head;

	public LinkedListStack(){
		head = null;
		N = 0;
	}
	
	@Override
	public E pop() {
		if (isEmpty())
			return null;
		E elem = head.element;
		head = head.next;
		N--;
		return elem; 
	}

	@Override
	public void push(E elem) {
		Node<E> oldHead = head;
		head = new Node<E>();
		head.element = elem;
		head.next = oldHead;
		N++;		
	}

	@Override
	public boolean isEmpty() {		
		return N == 0;
	}

	@Override
	public boolean contains(E elem) {
		Node<E> tmp = head;
		while (tmp!= null){
			if (tmp.element.equals(elem))
				return true;
			tmp = tmp.next;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<? extends E> collection) {		
		for (E elem: collection){
			if (!contains(elem))
				return false;			
		}
		return true;
	}
	
	@Override
	public int size(){
		return N;
	}
	
	public static <E> MyStack<E> createFromArray(E[] arr){
		MyStack<E>	stack = new LinkedListStack<>();
		for (E elem: arr){
			stack.push(elem);
		}
		return stack;
	}

	
	public static void main(String[] args){
		String [] arr = {"a","b","c","d"};
		MyStack<String> stack = createFromArray(arr);
		System.out.println(stack.contains("c"));
		System.out.println(stack.contains("f"));
		stack.push("e");
		while (!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

}
