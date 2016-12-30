package PracticeLeetCode;

public class _026RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{}));
	}
	public static int removeDuplicates(int[] nums) {
		int count=0;
		if(nums==null||nums.length==0)
			return count;
		count++;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]!=nums[i-1])
			{
					nums[count]=nums[i];
					count++;
			}
		}
		return count;
	}

}

