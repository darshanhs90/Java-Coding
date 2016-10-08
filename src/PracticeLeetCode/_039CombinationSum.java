package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

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
	private static void dfs(int[] candidates, int target,int currSum,int start, List<Integer> list, List<List<Integer>> outputList) {
		if(currSum>target)
			return;
		if(currSum==target)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(candidates, target, currSum+candidates[i], i, list, outputList);
			list.remove(list.size()-1);
		}
	}
}

