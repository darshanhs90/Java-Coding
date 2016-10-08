package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _040CombinationSum2 {
	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5},8));
	}
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(candidates==null||candidates.length==0)
			return outputList;
		Arrays.sort(candidates);
		List<Integer> list=new ArrayList<>();
		dfs(candidates,target,0,0,outputList,list);
		return outputList;
	}
	private static void dfs(int[] candidates, int target, int currSum, int start, List<List<Integer>> outputList,
			List<Integer> list) {
		if(currSum>target)
			return;
		if(currSum==target)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		int prev=-1;
		for (int i = start; i < candidates.length; i++) {
			if(prev!=candidates[i]){
				prev=candidates[i];
				list.add(candidates[i]);
				dfs(candidates, target, currSum+candidates[i], i+1, outputList, list);
				list.remove(list.size()-1);
			}
		}
	}
}

