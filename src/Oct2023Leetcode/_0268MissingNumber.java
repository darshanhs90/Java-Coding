package Oct2023Leetcode;

public class _0268MissingNumber {

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] { 3, 0, 1 }));
		System.out.println(missingNumber(new int[] { 0, 1 }));
		System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
		System.out.println(missingNumber(new int[] { 0 }));
	}

	public static int missingNumber(int[] nums) {
		int sum = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			sum += nums[i];
		}
		int expectedSum = (len) * (len + 1) / 2;
		return expectedSum - sum;
	}
}
