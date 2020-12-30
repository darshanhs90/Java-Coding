package Dec2020Leetcode;

public class _0137SingleNumberII {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 2, 2, 3, 2 }));
		System.out.println(singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 }));
	}

	public static int singleNumber(int[] nums) {
		int seenOnce = 00, seenTwice = 00;
		for (int i = 0; i < nums.length; i++) {
			System.out.println(~seenTwice);
			seenOnce = ~seenTwice & (seenOnce ^ nums[i]);

			seenTwice = ~seenOnce & (seenTwice ^ nums[i]);
		}
		return seenOnce;
	}
}
