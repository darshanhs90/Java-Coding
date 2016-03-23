package appleInterview;

public class _02PrepDocFindMissingElement {
	public static void main(String[] args) {
		int[] arr=new int[]{1,2,4,5,3,8,6};
		System.out.println(findMissing(arr));
	}

	private static int findMissing(int[] arr) {
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return -sum+(arr.length+1)*(arr.length+2)/2;
	}


}
