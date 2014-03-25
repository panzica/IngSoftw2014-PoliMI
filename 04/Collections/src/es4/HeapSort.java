package es4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import es2.Shuffle;

public class HeapSort {
	public static List<Integer> sort(Collection<Integer> collection){
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for (int i: collection)
			priorityQueue.add(i);
		List<Integer> result = new ArrayList<>();
		while (!priorityQueue.isEmpty())
			result.add(priorityQueue.remove());
		return result;
	}
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			list.add(i);
		//usiamo il metodo shuffle implementato nell'esercizio precedente
		Shuffle.shuffle(list, new Random());
		System.out.println(list);
		list = sort(list);
		System.out.println(list);
	}

}
