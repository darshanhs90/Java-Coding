package Nov2020_GoogPrep;

public class _011JumpGame {

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
	}

	public static boolean canJump(int[] nums) {
		int lastIndex = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (i + nums[i] >= lastIndex) {
				lastIndex = i ;
			}
		}
		return lastIndex == 0;
	}
}
