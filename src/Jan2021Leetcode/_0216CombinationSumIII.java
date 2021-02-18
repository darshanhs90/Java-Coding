package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0216CombinationSumIII {

	public static void main(String[] args) {
		System.out.println(combinationSum3(3, 7));
		System.out.println(combinationSum3(3, 9));
		System.out.println(combinationSum3(4, 1));
		System.out.println(combinationSum3(3, 2));
		System.out.println(combinationSum3(9, 45));
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (n <= 0)
			return output;
		dfs(0, 1, k, n, new ArrayList<Integer>(), output);
		return output;
	}

	public static void dfs(int currSum, int start, int k, int n, List<Integer> list, List<List<Integer>> output) {
		if (currSum == n && list.size() == k) {
			output.add(new ArrayList<Integer>(list));
			return;
		}
		if (currSum >= n | list.size() >= k)
			return;

		for (int i = start; i <= 9; i++) {
			list.add(i);
			dfs(currSum + i, i + 1, k, n, list, output);
			list.remove(list.size() - 1);
		}
	}
}
