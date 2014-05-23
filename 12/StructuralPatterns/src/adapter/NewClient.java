package adapter;

import java.util.Iterator;

public class NewClient {
	public static void main(String[] args){
		OldCode oldCode = new OldCode();
		NewCode newCode = new NewCode();
		
		Iterator<String> oldElements = new EnumerationToIteratorAdapter<>(oldCode.getOldElements());
		Iterator<String> newElements = newCode.getNewElements();
		
		while(oldElements.hasNext()){
			System.out.println(oldElements.next());
		}
		while(newElements.hasNext()){
			System.out.println(newElements.next());
		}
	}
}
