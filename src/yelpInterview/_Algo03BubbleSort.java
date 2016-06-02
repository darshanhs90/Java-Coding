package yelpInterview;

import java.util.Arrays;

public class _Algo03BubbleSort {

	public static void main(String a[]){
		System.out.println(Arrays.toString(bubbleSort(new int[]{3,4,1,2,7,5,9,3})));

	}

	private static int[] bubbleSort(int[] inputArray) {
		for (int i = 0; i < inputArray.length-1; i++) {
			for (int j = 0; j < inputArray.length-i-1; j++) {
				if(inputArray[j]>inputArray[j+1])
				{
					int temp=inputArray[j];
					inputArray[j]=inputArray[j+1];
					inputArray[j+1]=temp;
				}
			}
		}
		return inputArray;
	}


}

