package eBayPrep;

public class _055JumpGame {

	public static void main(String[] args) {
		System.out.println(canJump(new int[]{2,3,1,1,4}));
		System.out.println(canJump(new int[]{3,2,1,0,4}));

	}
	public static boolean canJump(int[] nums) {
		if(nums==null||nums.length<=1)
			return true;
		int maxReach=nums[0];
		for (int i = 0; i < nums.length; i++) {
			if(maxReach<=i && nums[i]==0)
				return false;
			if(nums[i]+i>maxReach)
				maxReach=nums[i]+i;
			if(maxReach>=nums.length-1)
				return true;
		}
		return false;
	}
}

