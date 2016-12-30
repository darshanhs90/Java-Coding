package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _039CombinationSum {
	public static void main(String[] args) {
		System.out.println(combinationSum(new int[]{2, 3, 5, 7},7));
	}
	static List<List<Integer>> outputList;
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		outputList=new ArrayList<>();
		List<Integer> list=new ArrayList<>();
		if(candidates==null||candidates.length==0)
			return outputList;
		dfs(0,0,candidates,target,list);
		return outputList;
	}
	private static void dfs(int sum,int index,int[] candidates, int target, List<Integer> list) {
		if(sum>target)
			return;
		if(sum==target)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(sum+candidates[i], i, candidates, target, list);
			list.remove(list.size()-1);	
		}
	}
}

