package yelpInterview;

import java.util.Arrays;

public class _Array36CountTriangles {
	static boolean[][] visited;
	public static void main(String a[]){
		int inputArray[]={10, 21, 22, 100, 101, 200, 300};

		System.out.println(countTriangles(inputArray));
	}
	private static int countTriangles(int[] inputArray) {
		Arrays.sort(inputArray);
		int count=0;
		for (int i = 0; i < inputArray.length-2; i++) {
			int k=i+2;
			for (int j = i+1; j < inputArray.length; j++) {


				while(k<inputArray.length && inputArray[i] + inputArray[j] > inputArray[k])
					k++;
				count+=k-j-1;
			}
		}
		return count;
	}


}