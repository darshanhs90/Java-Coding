package Jan2021Leetcode;

public class _0485MaxConsecutiveOnes {

	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int maxNos = 0;

		int curr = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				curr++;
			} else {
				curr = 0;
			}

			maxNos = Math.max(maxNos, curr);
		}
		return maxNos;
	}

}
