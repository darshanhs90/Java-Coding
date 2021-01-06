package Dec2020Leetcode;

public class _0485MaxConsecutiveOnes {

	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int count = 0;
		int maxCount = count;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
			} else {
				count = 0;
			}
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}

}
