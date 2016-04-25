package yelpInterview;

import java.util.Arrays;

public class _Array42FindRepeatingAndMissing {
	public static void main(String a[]){
		int[] inputArray=new int[]{3, 1, 3};
		System.out.println(Arrays.toString(findRepeatMissing(inputArray)));
		inputArray=new int[]{4, 3, 6, 2, 1, 1};
		System.out.println(Arrays.toString(findRepeatMissing(inputArray)));
	}

	private static int[] findRepeatMissing(int[] inputArray) {
		int[] outputArr=new int[2];
		for (int i = 0; i < inputArray.length; i++) {
			if(inputArray[Math.abs(inputArray[i])-1]>0)
				inputArray[Math.abs(inputArray[i])-1]=-1*inputArray[Math.abs(inputArray[i])-1];
			else
				outputArr[0]=(Math.abs(inputArray[i]));
		}
		for (int i = 0; i < inputArray.length; i++) {
			if(inputArray[i]>0)
				outputArr[1]=(i+1);
		}
		
		
		return outputArr;
	}




}