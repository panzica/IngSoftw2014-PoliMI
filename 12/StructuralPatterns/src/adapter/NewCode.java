package adapter;

import java.util.ArrayList;
import java.util.Iterator;

public class NewCode {
	private ArrayList<String> arrayList;
	
	public NewCode(){
		arrayList = new ArrayList<>();
		arrayList.add("newElement1");
		arrayList.add("newElement2");
		arrayList.add("newElement3");
	}
	
	public Iterator<String> getNewElements(){
		return arrayList.iterator();
	}
}
