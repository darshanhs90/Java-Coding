package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0077Combinations {

	public static void main(String[] args) {
		System.out.println(combine(4, 2));
		System.out.println(combine(1, 1));
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		dfs(1, n, k, new ArrayList<Integer>(), output);
		return output;
	}

	public static void dfs(int index, int n, int k, List<Integer> list, List<List<Integer>> output) {
		if (list.size() == k) {
			output.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = index; i <= n; i++) {
			list.add(i);
			dfs(i + 1, n, k, list, output);
			list.remove(list.size() - 1);
		}
	}
}
