package LeetCodePractice;

public class _153FindMinimuminRotatedSortedArray {
	public static void main(String[] args) {
		System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
	}
	public static int findMin(int[] nums) {
		return findMinimum(nums,0,nums.length-1);
	}
	private static int findMinimum(int[] nums, int low, int high) {
		if(low<=high)
		{
			
		}
		return Integer.MAX_VALUE;
	}
}

