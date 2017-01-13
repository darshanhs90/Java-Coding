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
		List<Integer> list=new ArrayList<>();
		Arrays.sort(candidates);
		dfs(0,0,candidates,target,list,outputList);
		return outputList;
	}
	private static void dfs(int index,int sum, int[] candidates, int target, List<Integer> list, List<List<Integer>> outputList) {
		if(index>candidates.length||sum>target)
			return;
		if(sum==target)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		int prev=-1;
		for (int i = index; i < candidates.length; i++) {
			if(candidates[i]!=prev){
				list.add(candidates[i]);
				dfs(i+1, sum+candidates[i], candidates, target, list, outputList);
				list.remove(list.size()-1);
				prev=candidates[i];
			}
		}
	}
}

