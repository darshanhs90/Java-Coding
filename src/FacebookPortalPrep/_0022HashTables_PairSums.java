package FacebookPortalPrep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _0022HashTables_PairSums {

	public static void main(String[] args) {
		System.out.println(numberOfWays(new int[] { 1, 2, 3, 4, 3 }, 6));
		System.out.println(numberOfWays(new int[] { 1, 5, 3, 3, 3 }, 6));
	}

	public static int numberOfWays(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.compute(arr[i], (key, val) -> val == null ? 1 : val + 1);
		}
		int count = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			int num1 = entry.getKey();
			int num2 = k - entry.getKey();

			if (visited.contains(num1) || visited.contains(num2))
				continue;

			if (map.containsKey(num2)) {
				if (num1 == num2) {
					count += (entry.getValue() * (entry.getValue() - 1)) / 2;
				} else {
					count += entry.getValue() * map.get(num2);
				}
			}
			visited.add(num1);
			visited.add(num2);
		}
		return count;
	}
}
