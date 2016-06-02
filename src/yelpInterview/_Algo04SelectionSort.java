package yelpInterview;

import java.util.Arrays;

public class _Algo04SelectionSort {

	public static void main(String a[]){
		System.out.println(Arrays.toString(selectionSort(new int[]{3,4,1,2,7,5,9,3})));

	}

	private static int[] selectionSort(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			int minIndex=i;
			for (int j = i+1; j < inputArray.length; j++) {
				if(inputArray[j]<inputArray[minIndex])
				{
					minIndex=j;
				}
			}
			int temp=inputArray[i];
			inputArray[i]=inputArray[minIndex];
			inputArray[minIndex]=temp;
		}
		return inputArray;
	}


}

