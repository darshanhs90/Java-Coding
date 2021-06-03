package May2021GoogLeetcode;

import java.util.HashMap;

public class _0904FruitIntoBaskets {
	public static void main(String[] args) {
		System.out.println(totalFruit(new int[] { 1, 2, 1 }));
		System.out.println(totalFruit(new int[] { 0, 1, 2, 2 }));
		System.out.println(totalFruit(new int[] { 1, 2, 3, 2, 2 }));
		System.out.println(totalFruit(new int[] { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 }));
	}

	public static int totalFruit(int[] tree) {
		int left = 0, right = 0;
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (right < tree.length) {
			int val = tree[right];
			map.compute(val, (k, v) -> v == null ? 1 : v + 1);
			while (map.size() > 2) {
				val = tree[left];
				map.put(val, map.get(val) - 1);
				if (map.get(val) == 0)
					map.remove(val);
				left++;
			}

			max = Math.max(max, right - left + 1);
			right++;
		}
		return max;
	}
}
