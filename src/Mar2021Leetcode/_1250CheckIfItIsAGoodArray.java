package Mar2021Leetcode;

public class _1250CheckIfItIsAGoodArray {
	public static void main(String[] args) {
		System.out.println(isGoodArray(new int[] { 12, 5, 7, 23 }));
		System.out.println(isGoodArray(new int[] { 29, 6, 10 }));
		System.out.println(isGoodArray(new int[] { 3, 6 }));
	}

	public static boolean isGoodArray(int[] nums) {
		int res = nums[0];

		for (int num : nums) {
			res = gcd(res, num);
		}
		return res == 1;
	}

	public static int gcd(int a, int b) {

		if (b == 0)
			return a;

		return gcd(b, a % b);
	}
}
