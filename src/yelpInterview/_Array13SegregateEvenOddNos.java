package yelpInterview;

import java.util.Arrays;

public class _Array13SegregateEvenOddNos {
	public static void main(String a[]){
		int inputArray[] = {12, 34, 45, 9, 8, 90, 3};
		System.out.println(Arrays.toString(segregateNos(inputArray)));
	}

	private static int[] segregateNos(int[] inputArray) {
		int left=0;
		int right=inputArray.length-1;
		while(left<right)
		{
			while(inputArray[left]%2==0 )
			{
				left++;
			}
			while(inputArray[right]%2!=0)
			{
				right--;
			}
			if(left<right){
				inputArray[left]=inputArray[left] ^ inputArray[right];
				inputArray[right]=inputArray[left] ^ inputArray[right];
				inputArray[left]=inputArray[left] ^ inputArray[right];
			}
		}
		return inputArray;
	}

}