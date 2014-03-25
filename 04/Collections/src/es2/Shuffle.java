package es2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shuffle {
	public static <E> void swap(List<E> a, int i, int j) {
		    E tmp = a.get(i);
		    a.set(i, a.get(j));
		    a.set(j, tmp);
	}
	
	public static void shuffle(List<Integer> list, Random rnd) {
		    for (int i = list.size(); i > 1; i--)
		        swap(list, i - 1, rnd.nextInt(i));
	}
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList();
		for (int i = 0; i < 10; i++){
			list.add(i);
		}
		System.out.println(list);
		shuffle(list, new Random());
		System.out.println(list);
	}


}
