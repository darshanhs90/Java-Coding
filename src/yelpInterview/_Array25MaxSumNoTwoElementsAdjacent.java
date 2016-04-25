package yelpInterview;

public class _Array25MaxSumNoTwoElementsAdjacent {
	public static void main(String a[]){
		int arr[] = {5,  5, 10, 40, 50, 35};
		System.out.println(findSum(arr));
	}

	private static int findSum(int[] arr) {
		int incl=arr[0],excl=0;
		for (int i = 1; i < arr.length; i++) {
			int prevExcl=excl;
			int prevIncl=incl;
			incl=excl+arr[i];
			excl=Math.max(prevExcl,prevIncl);
		}
		return Math.max(incl, excl);
	}






}