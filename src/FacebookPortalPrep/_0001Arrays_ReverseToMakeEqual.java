package FacebookPortalPrep;

import java.util.HashMap;

public class _0001Arrays_ReverseToMakeEqual {

	public static void main(String[] args) {
		System.out.println(areTheyEqual(new int[] { 1, 2, 3, 4 }, new int[] { 1, 4, 3, 2 }));

	}

	public static boolean areTheyEqual(int[] a, int[] b) {

		if (a.length != b.length)
			return false;
		// Write your code here
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {
			map.compute(a[i], (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < b.length; i++) {
			if (!map.containsKey(b[i]) || map.get(b[i]) <= 0)
				return false;
			map.put(b[i], map.get(b[i]) - 1);
		}
		return true;
	}
}
