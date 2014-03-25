package es5;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FrequencyCounter {
	public static void count(String text){
		StringTokenizer tokenizer = new StringTokenizer(text);
		Map<String,Integer> frequencyCounterMap = new HashMap<String,Integer>();
		while (tokenizer.hasMoreTokens()){
			String word = tokenizer.nextToken();
			Integer freq = frequencyCounterMap.get(word);
			frequencyCounterMap.put(word,(freq == null) ? 1 : freq + 1);
		}
		System.out.println(frequencyCounterMap.size() + " parole distinte");
		System.out.println(frequencyCounterMap);
	}
	public static void main(String[] args){
		String text = "if it is to be it is up to me to delegate";
		count(text);
	}

}
