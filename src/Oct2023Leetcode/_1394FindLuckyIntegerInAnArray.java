package Oct2023Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1394FindLuckyIntegerInAnArray {
	public static void main(String[] args) {
		System.out.println(findLucky(new int[] { 2, 2, 3, 4 }));
		System.out.println(findLucky(new int[] { 1, 2, 2, 3, 3, 3 }));
		System.out.println(findLucky(new int[] { 2, 2, 2, 3, 3 }));
	}

	public static int findLucky(int[] arr) {
		int output = -1;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			map.compute(num, (k, v) -> v == null ? 1 : v + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getKey() == entry.getValue()) {
				output = Math.max(output, entry.getKey());
			}
		}

		return output;
	}
}
