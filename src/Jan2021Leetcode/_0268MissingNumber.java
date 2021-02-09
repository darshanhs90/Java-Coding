package Jan2021Leetcode;

public class _0268MissingNumber {

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] { 3, 0, 1 }));
		System.out.println(missingNumber(new int[] { 0, 1 }));
		System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
		System.out.println(missingNumber(new int[] { 0 }));
	}

	public static int missingNumber(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		int reqdSum = nums.length * (nums.length + 1) / 2;
		if (sum == reqdSum)
			return 0;
		return reqdSum - sum;
	}
}
