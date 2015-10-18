package leetCode;

/*
 * Link : https://leetcode.com/problems/find-peak-element/
 */

public class _162PeakElement {
		public static int findPeakElement(int[] nums) {
			if(nums.length==1)
				return 0;
			for (int i = 0; i < nums.length; i++) {
				if(i==0){
					if(nums[i]>nums[i+1])
						return i;
				}
				else if(i==nums.length-1){
					if(nums[i]>nums[i-1])
						return i;
				}
				else
					if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
						return i;
			}
			return 0;
		}
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[]{1,2,3,1}));
	}
}