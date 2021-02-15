package Jan2021Leetcode;

import java.util.Arrays;

public class _0045JumpGameII {

	public static void main(String[] args) {
		System.out.println(jump(new int[] { 3, 2, 1, 1, 4 }));
		System.out.println(jump(new int[] { 2, 3, 0, 1, 4 }));
	}

	public static int jump(int[] nums) {
		if(nums == null||nums.length <=1)
			return 0;
		int[] reach = new int[nums.length];
		Arrays.fill(reach, Integer.MAX_VALUE);
		
		int reachVal = nums[0];
		if(reachVal >= nums.length-1)
			return 1;
		for (int i = 0; i <= reachVal; i++) {
			reach[i] = 1;
		}
		
		for (int i = 1; i < nums.length; i++) {
			int currVal = reach[i];
			for (int j = i+1; j <= i+nums[i] && j< nums.length; j++) {
				reach[j] = Math.min(reach[j], currVal+1);
			}
		}
		
		return reach[nums.length-1];
	}

}
