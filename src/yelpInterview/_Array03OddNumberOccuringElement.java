package yelpInterview;

public class _Array03OddNumberOccuringElement {
	public static void main(String a[]){
		int inputArray[] = {1, 2, 3, 2, 3, 1, 3};
		System.out.println(findOddOccuringNumber(inputArray));
	}

	private static int findOddOccuringNumber(int[] inputArray) {
		int output=inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			output=output^inputArray[i];
		}
		return output;
	}


}

