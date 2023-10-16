package Oct2023Leetcode;

import java.util.HashMap;

public class _1748SumOfUniqueElements {
	public static void main(String[] args) {
		System.out.println(sumOfUnique(new int[] { 1, 2, 3, 2 }));
		System.out.println(sumOfUnique(new int[] { 1, 1, 1, 1, 1 }));
		System.out.println(sumOfUnique(new int[] { 1, 2, 3, 4, 5 }));
	}

	public static int sumOfUnique(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (!map.containsKey(num)) {
				sum += num;
				map.put(num, 1);
			} else {
				if (map.get(num) == 1) {
					map.put(num, 2);
					sum -= num;
				}
			}
		}
		return sum;
	}
}
