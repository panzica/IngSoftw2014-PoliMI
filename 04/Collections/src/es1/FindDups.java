package es1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FindDups {
	public static void findDups(Collection<String> words){
		Set<String> set = new HashSet<String>();
		for (String s: words){
			set.add(s);
		}
		System.out.println("Unique values, dim : " + 
		set.size() + " Elements:" + set);
			
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String word = null;
		System.out.println("Inserire le parole, (q per uscire)");
		List<String> words = new ArrayList<String>();
		word = s.nextLine();		
		while (!word.equals("q") ){
			words.add(word);
			word = s.nextLine();
		} 
		findDups(words);
		s.close();
	}

}
