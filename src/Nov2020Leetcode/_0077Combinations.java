package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0077Combinations {

	public static void main(String[] args) {
		System.out.println(combine(4, 2));
		System.out.println(combine(1, 1));
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		combine(0, n, k, new ArrayList<Integer>(), output);
		return output;
	}

	public static void combine(int index, int n, int k, List<Integer> list, List<List<Integer>> out) {
		if (list.size() > k)
			return;
		if (list.size() == k) {
			out.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = index + 1; i <= n; i++) {
			list.add(i);
			combine(i, n, k, list, out);
			list.remove(list.size() - 1);
		}
	}
}
