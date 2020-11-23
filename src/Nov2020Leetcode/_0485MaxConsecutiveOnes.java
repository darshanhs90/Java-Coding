package Nov2020Leetcode;

public class _0485MaxConsecutiveOnes {

	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int maxOnes = 0;
		int currOnes = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				currOnes++;
			} else {
				maxOnes = Math.max(currOnes, maxOnes);
				currOnes = 0;
			}
		}
		return Math.max(currOnes, maxOnes);
	}
}
