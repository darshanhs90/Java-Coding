package yelpInterview;

import java.util.Arrays;

public class _Algo01SortArrayWaveForm {

	public static void main(String a[]){
		System.out.println(Arrays.toString(sortArrayWaveForm(new int[]{10, 5, 6, 3, 2, 20, 100, 80})));
		System.out.println(Arrays.toString(sortArrayWaveForm1(new int[]{10, 5, 6, 3, 2, 20, 100, 80})));
		System.out.println(Arrays.toString(sortArrayWaveForm(new int[]{20, 10, 8, 6, 4, 2})));
		System.out.println(Arrays.toString(sortArrayWaveForm(new int[]{2, 4, 6, 8, 10, 20})));
		System.out.println(Arrays.toString(sortArrayWaveForm(new int[]{3, 6, 5, 10, 7, 20})));

	}

	private static int[] sortArrayWaveForm(int[] inputArray) {
		Arrays.sort(inputArray);
		for (int i = 0; i < inputArray.length; i++) {
			if(i+1<inputArray.length)
			{
				int temp=inputArray[i];
				inputArray[i]=inputArray[i+1];
				inputArray[i+1]=temp;
				i++;
			}
		}
		return inputArray;
	}

	private static int[] sortArrayWaveForm1(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i+=2) {
			if(i>0 && inputArray[i-1]>inputArray[i])
			{
				int temp=inputArray[i-1];
				inputArray[i-1]=inputArray[i];
				inputArray[i]=temp;
			}
			if(i<inputArray.length-1 && inputArray[i+1]>inputArray[i])
			{
				int temp=inputArray[i+1];
				inputArray[i+1]=inputArray[i];
				inputArray[i]=temp;
			}
		}
		return inputArray;
	}

}

