package PracticeLeetCode;

public class _055JumpGame {
	public static void main(String[] args) {
		System.out.println(canJump(new int[]{2,3,1,1,4}));//true
		System.out.println(canJump(new int[]{3,2,1,0,4}));//false
		System.out.println(canJump(new int[]{2,0}));//true
		System.out.println(canJump(new int[]{0}));//true
		System.out.println(canJump(new int[]{0,2}));//false
		System.out.println(canJump(new int[]{2,0,0}));
	}
	public static boolean canJump(int[] nums) {
		if(nums==null||nums.length==0)
			return true;
		int maxReach=nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]==0 && maxReach<i||maxReach<i)
				return false;
			if(maxReach>=nums.length)
				return true;
			maxReach=Math.max(maxReach, nums[i]+i);
		}
		return true;
	}
}

