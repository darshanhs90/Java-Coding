package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _039CombinationSum {
	public static void main(String[] args) {
		System.out.println(combinationSum(new int[]{2, 3, 6, 7},7));
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(candidates==null||candidates.length==0)
			return outputList;
		List<Integer> list=new ArrayList<>();
		dfs(candidates,target,0,0,list,outputList);
		return outputList;
	}
	static Set<List<Integer>> set=new HashSet<>();
	private static void dfs(int[] candidates, int target, int sum,int index,List<Integer> list, List<List<Integer>> outputList) {
		if(sum<0||sum>target)
			return;
		if(sum==target)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(candidates, target, sum+candidates[i],i, list, outputList);
			list.remove(list.size()-1);
		}
	}
}

