package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

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
		HashSet<List<Integer>> outSet = new HashSet<List<Integer>>();
		dfs(0, new ArrayList<Integer>(), new TreeSet<Integer>(), output, outSet, k, n);
		return output;
	}

	public static void dfs(int currSum, List<Integer> list, TreeSet<Integer> set, List<List<Integer>> output,
			HashSet<List<Integer>> outSet, int k, int n) {
		if (currSum > n || list.size() > k)
			return;
		if (currSum == n && list.size() == k) {
			Collections.sort(list);
			if (!outSet.contains(list)) {
				output.add(new ArrayList<Integer>(list));
				outSet.add(list);
			}
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (!set.contains(i)) {
				set.add(i);
				list.add(i);
				dfs(currSum + i, list, set, output, outSet, k, n);
				list.remove(Integer.valueOf(i));
				set.remove(i);
			}
		}
	}
}
