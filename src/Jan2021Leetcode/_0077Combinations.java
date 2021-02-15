package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0077Combinations {

	public static void main(String[] args) {
		System.out.println(combine(4, 2));
		System.out.println(combine(1, 1));
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (n <= 0 || k <= 0)
			return output;
		combine(1, n, k, new ArrayList<Integer>(), output);
		return output;
	}

	public static void combine(int start, int n, int k, List<Integer> list, List<List<Integer>> output) {
		if (list.size() == k) {
			output.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = start; i <= n; i++) {
			list.add(i);
			combine(i + 1, n, k, list, output);
			list.remove(list.size() - 1);
		}
	}
}
