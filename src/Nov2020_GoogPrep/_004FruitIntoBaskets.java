package Nov2020_GoogPrep;

import java.util.HashMap;

public class _004FruitIntoBaskets {

	public static void main(String[] args) {
		System.out.println(totalFruit(new int[] { 1, 2, 1 }));
		System.out.println(totalFruit(new int[] { 0, 1, 2, 2 }));
		System.out.println(totalFruit(new int[] { 1, 2, 3, 2, 2 }));
		System.out.println(totalFruit(new int[] { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 }));
		System.out.println(totalFruit(new int[] { 1, 1, 1, 2, 1, 3, 3, 3, 3, 3 }));
		System.out.println(totalFruit(new int[] { 1, 1, 1, 2, 2, 3, 3, 3, 3, 3 }));
	}

	public static int totalFruit(int[] tree) {
		if (tree.length <= 2)
			return tree.length;
		int max = 0;
		int left = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < tree.length; i++) {
			if (map.containsKey(tree[i])) {
				map.put(tree[i], map.get(tree[i]) + 1);
			} else {
				map.put(tree[i], 1);
			}

			if (map.size() == 3) {
				while (map.size() == 3) {
					if (map.get(tree[left]) == 1) {
						map.remove(tree[left]);
					} else {
						map.put(tree[left], map.get(tree[left]) - 1);
					}
					left++;
				}
			}

			max = Math.max(max, i - left + 1);
		}
		return max;
	}
}
