package adapter;

import java.util.Enumeration;

public class LegacyClient {
	public static void main(String[] args){
		OldCode oldCode = new OldCode();
		NewCode newCode = new NewCode();
		
		Enumeration<String> oldElements = oldCode.getOldElements();
		Enumeration<String> newElements = new IteratorToEnumerationAdapter<>(newCode.getNewElements());
		
		while (oldElements.hasMoreElements()){
			System.out.println(oldElements.nextElement());
		}
		while (newElements.hasMoreElements()){
			System.out.println(newElements.nextElement());
		}
	}
	

}
