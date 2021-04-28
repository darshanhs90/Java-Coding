package May2021PrepLeetcode;

import java.util.HashMap;
import java.util.Map;

public class _1814CountNicePairsInAnArray {
	public static void main(String[] args) {
		System.out.println(countNicePairs(new int[] { 42, 11, 1, 97 }));
		System.out.println(countNicePairs(new int[] { 13, 10, 35, 24, 76 }));
	}

	public static int countNicePairs(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int reverseNum = reverse(num);
			int sum = num - reverseNum;
			map.compute(sum, (key, val) -> val == null ? 1 : val + 1);
		}

		long count = 0;
		long mod = (long) (1e9 + 7);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				count += entry.getValue() * (entry.getValue() - 1) / 2;
			}
		}
		return (int) (count % mod);
	}

	public static int reverse(int num) {
		String str = String.valueOf(num);
		String reverse = new StringBuilder(str).reverse().toString();
		return Integer.parseInt(reverse);
	}
}
