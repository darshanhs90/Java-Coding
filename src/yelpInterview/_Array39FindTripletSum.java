package yelpInterview;

import java.util.Arrays;

public class _Array39FindTripletSum {
	public static void main(String a[]){
		int[] inputArray=new int[]{1, 4, 45, 6, 10, 8};
		System.out.println(findTripletSum(inputArray,22));
	}

	private static boolean findTripletSum(int[] inputArray, int sum) {
		Arrays.sort(inputArray);
		for (int i = 0; i < inputArray.length-2; i++) {
			int low=0;
			int high=inputArray.length-1;
			while(low<high){
				int outputSum=inputArray[i]+inputArray[low]+inputArray[high];
				if(outputSum==sum){
					System.out.println(inputArray[i]+"/"+inputArray[low]+"/"+inputArray[high]);
					return true;
				}
				if(outputSum>sum)
					high--;
				else
					low++;
			}
		}
		return false;
	}


}