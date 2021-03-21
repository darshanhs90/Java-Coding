package Feb2021Leetcode;

public class _0045JumpGameII {

	public static void main(String[] args) {
		System.out.println(jump(new int[] { 3, 2, 1, 1, 4 }));
		System.out.println(jump(new int[] { 2, 3, 0, 1, 4 }));
		System.out.println(jump(new int[] { 2, 1 }));
		System.out.println(jump(new int[] { 0 }));
	}

	public static int jump(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int nextMax = 0;
		int currMax = 0;
		int count = 0;

		for (int i = 0; i < nums.length-1; i++) {
			nextMax = Math.max(nextMax, i+nums[i]);
			if(i== currMax)
			{
				count++;
				currMax = nextMax;
			}
		}
		return count;
	}

}
