package yelpInterview;

public class _Array17EquilibriumIndex {
	public static void main(String a[]){
		int inputArray[] = {-7, 1, 5, 2, -4, 3, 0};
		System.out.println(findEquilibriumPoint(inputArray));
	}

	private static int findEquilibriumPoint(int[] inputArray) {
		int index=0,rightSum=0;
		for (int i = 0; i < inputArray.length; i++) {
			rightSum+=inputArray[i];
		}
		int leftSum=0;
		for (index = 0; index < inputArray.length; index++) {
			leftSum+=inputArray[index];
			rightSum-=inputArray[index];
			if(leftSum==rightSum)
				break;
		}
		return index;
	}


}