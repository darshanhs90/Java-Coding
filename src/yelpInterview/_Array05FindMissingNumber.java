package yelpInterview;

public class _Array05FindMissingNumber {
	public static void main(String a[]){
		int inputArray[] = {1, 2, 4, 6, 3, 7, 8};
		System.out.println(findMissingNumber(inputArray));
	}

	private static int findMissingNumber(int[] inputArray) {
		int n=inputArray.length+1;
		int sum=(int)(n*(n+1)/(float)2);
		for (int i = 0; i < inputArray.length; i++) {
			sum-=inputArray[i];
		}
		return sum;
	}


}

