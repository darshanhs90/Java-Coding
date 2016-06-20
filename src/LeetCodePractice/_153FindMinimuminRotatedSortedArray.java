package LeetCodePractice;

public class _153FindMinimuminRotatedSortedArray {
	public static void main(String[] args) {
		System.out.println(findMin(new int[]{3,1,2}));
	}
	public static int findMin(int[] nums) {
		return findMinimum(nums,0,nums.length-1);
	}
	private static int findMinimum(int[] arr, int left, int right) {
		if(left==right)
		{	
			return arr[left];
		}
		if (Math.abs(right - left) == 1)
			return Math.min(arr[left], arr[right]);
		int mid=(left+right)/2;
		if(arr[left]<arr[right])
			return arr[left];
		else if(arr[mid]>arr[left])
			return findMinimum(arr, mid, right);
		else
			return findMinimum(arr, left, mid);

	}
}

