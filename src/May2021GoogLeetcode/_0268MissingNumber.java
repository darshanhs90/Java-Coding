package May2021GoogLeetcode;

public class _0268MissingNumber {

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] { 3, 0, 1 }));
		System.out.println(missingNumber(new int[] { 0, 1 }));
		System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
		System.out.println(missingNumber(new int[] { 0 }));
	}

	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int total = n * (n + 1) / 2;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return total - sum;
	}
}
