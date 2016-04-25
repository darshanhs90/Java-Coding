package yelpInterview;

import java.util.Arrays;

public class _Array37FindfourElements {
	static boolean[][] visited;
	public static void main(String a[]){
		int inputArray[]={10, 2, 3, 4, 5, 9, 7, 8};
		int X = 23;
		System.out.println(findFourElements(inputArray,X));
	}
	private static boolean findFourElements(int[] inputArray, int x) {
		Arrays.sort(inputArray);
		for (int i = 0; i < inputArray.length-3; i++) {
			for (int j = i+1; j < inputArray.length-2; j++) {
				int low=j+1;
				int high=inputArray.length-1;
				int sum=inputArray[i]+inputArray[j];
				while(low<high)
				{	
					int totalSum=sum+inputArray[low]+inputArray[high];
					if(totalSum==x){
						System.out.println(inputArray[i]+"/"+inputArray[j]+"/"+inputArray[low]+"/"+inputArray[high]);
						return true;
					}
					if(totalSum>x)
					{
						high--;
					}
					else
						low++;
				}
			}
		}
		return false;
	}



}