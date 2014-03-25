package es6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindingAnagrams {
	private static String ordinaStringa(String stringa){
		char[] arr = stringa.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	public static void findAnagrams(String fileName, int minimumSize){
		Scanner s;
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		try {
			s = new Scanner(new File(fileName));			
			while (s.hasNextLine()){
				String word = s.nextLine();
				String wordOrdinata = ordinaStringa(word);
				List<String> l = map.get(wordOrdinata);
				if (l == null){
					l = new ArrayList<String>();
					map.put(wordOrdinata, l);				
				}
				l.add(word);			
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// stampa tutti gruppi di parole con dimensione almeno pari a minimumSize
		for (List<String> l : map.values()){
			if (l.size() >= minimumSize)
				System.out.println(l.size() + ": " + l);
		}
		
	}
	public static void main(String[] args){
		final String fileName = "dictionary.txt";
		final int minimumSize = 8;
		findAnagrams(fileName,minimumSize);
		
	}

}
