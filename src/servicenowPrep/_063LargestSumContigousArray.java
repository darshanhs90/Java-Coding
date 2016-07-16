package servicenowPrep;

public class _063LargestSumContigousArray
{

	public static void main(String[] args) {
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(findLargestSum(arr));
	}

	private static int findLargestSum(int[] arr) {
		int currSum=0,max=0;
		for (int i = 0; i < arr.length; i++) {
			if(currSum+arr[i]<0)
				currSum=0;
			else{
				currSum+=arr[i];
				max=Math.max(max, currSum);
			}
		}
		return max;
	}

	

}