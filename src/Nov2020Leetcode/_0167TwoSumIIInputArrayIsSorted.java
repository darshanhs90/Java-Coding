package Nov2020Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _0167TwoSumIIInputArrayIsSorted {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 3, 4 }, 6)));
		System.out.println(Arrays.toString(twoSum(new int[] { -1, 0 }, -1)));
		System.out.println(Arrays.toString(twoSum(new int[] { 0, 0, 3, 4 }, 0)));
	}

	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (!map.containsKey(numbers[i]))
				map.put(numbers[i], i);

			if (map.containsKey(numbers[i]) && target - numbers[i] == numbers[i] && map.get(numbers[i]) != i) {
				return new int[] { map.get(target - numbers[i]) + 1, i + 1 };
			} else if (map.containsKey(numbers[i]) && map.containsKey(target - numbers[i])
					&& map.get(target - numbers[i]) != i) {
				return new int[] { map.get(target - numbers[i]) + 1, map.get(numbers[i]) + 1 };
			}
		}
		return null;
	}
}
