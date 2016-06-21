package LeetCodePractice;

public class _162FindPeakElement {

	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
		//1,0,2,3,4,5,6,7,8,9,10
	}

	public static int findPeakElement(int[] nums) {
		return findPeakElement(nums,0,nums.length-1);
	}

	private static int findPeakElement(int[] arr, int left, int right) {

		int mid=(left+right)/2;
		if(arr[mid]>=arr[mid-1] && arr[mid]>=arr[mid+1])
			return arr[mid];
		else if(arr[left]>arr[right])
		{
			return findPeakElement(arr,mid,right);
		}
		else
			return findPeakElement(arr,left,mid);
	}
}

