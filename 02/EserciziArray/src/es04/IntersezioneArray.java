package es04;

public class IntersezioneArray {

	//l'implementazione assume che non ci siano elementi ripetuti in arr1, arr2
	private static int [] intersect(int [] arr1, int [] arr2){
		
		int dimResult = 0;
		for (int el1: arr1){
			for (int el2: arr2){
				if (el1 == el2){
					dimResult++;
					break;
				}
			}			
		}
		
		int [] result = new int[dimResult];
		int k = 0;
		for (int el1: arr1){
			for (int el2: arr2){
				if (el1 == el2){
					result[k++] = el1;
					break;
				}
			}			
		}
		
		return result;
	}
	private static void printArray(int[] arr){
		for (int el : arr){
			System.out.print(el+ " ");
		}
	}
	public static void main(String [] args){		
		int [] arr1 ={1,2,3,4,5};
		int [] arr2 ={3,4,5,6,7,8};
		printArray(intersect(arr1, arr2));
		
	}
}
