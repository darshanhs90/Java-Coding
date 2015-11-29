package GeeksforGeeksPractice;

/*
 * Link: http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 */
public class _0125EquilibriumIndexArray {
	public static void main(String[] args) {
		int arr[] = {-7, 1, 5, 2, -4, 3, 0};
		findEqulibriumPoint(arr);
	}

	private static void findEqulibriumPoint(int[] arr) {
		int sum=0,leftSum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			sum=sum-arr[i];
			if(leftSum==sum){
				System.out.println(i);
				break;
			}
			leftSum+=arr[i];
		}
		
	}

	
}
