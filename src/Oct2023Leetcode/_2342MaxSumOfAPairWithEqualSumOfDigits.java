package Oct2023Leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _2342MaxSumOfAPairWithEqualSumOfDigits {
	public static void main(String[] args) {
		System.out.println(maximumSum(new int[] { 18, 43, 36, 13, 7 }));
		System.out.println(maximumSum(new int[] { 10, 12, 19, 14 }));
		System.out.println(maximumSum(new int[] { 4, 6, 10, 6 }));

	}

	public static int maximumSum(int[] nums) {
		HashMap<Integer, TreeMap<Integer, Integer>> map = new HashMap<Integer, TreeMap<Integer, Integer>>();
		int maxValue = -1;
		for (int i = 0; i < nums.length; i++) {
			int digitSum = getDigitSum(nums[i]);
			if (!map.containsKey(digitSum)) {
				map.put(digitSum, new TreeMap<Integer, Integer>(Collections.reverseOrder()));
			}
			TreeMap<Integer, Integer> currMap = map.get(digitSum);
			currMap.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
		}

		for (Map.Entry<Integer, TreeMap<Integer, Integer>> entry : map.entrySet()) {
			TreeMap<Integer, Integer> numMap = entry.getValue();
			Map.Entry<Integer, Integer> firstEntry = numMap.pollFirstEntry();
			if (firstEntry.getValue() > 1) {
				maxValue = Math.max(maxValue, firstEntry.getKey() * 2);
			} else if (!numMap.isEmpty()) {
				Map.Entry<Integer, Integer> secondEntry = numMap.pollFirstEntry();
				maxValue = Math.max(maxValue, firstEntry.getKey() + secondEntry.getKey());
			}

		}
		return maxValue;
	}

	public static int getDigitSum(int num) {
		String str = String.valueOf(num);
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			count += Integer.parseInt(str.charAt(i) + "");
		}
		return count;
	}
}
