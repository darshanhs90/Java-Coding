package yelpInterview;

import java.util.HashSet;

public class _Array14FindRepeatingNos {
	public static void main(String a[]){
		int inputArray[] = {4, 2, 4, 5, 2, 3, 13};
		findNos(inputArray);
	}

	private static void findNos(int[] inputArray) {
		HashSet<Integer> elementCount=new HashSet<>();
		for (int i = 0; i < inputArray.length; i++) {
			if(elementCount.contains(inputArray[i]))
				System.out.println(inputArray[i]);
			else
				elementCount.add(inputArray[i]);
		}
	}
}