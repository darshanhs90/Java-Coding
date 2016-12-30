package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _040CombinationSum2 {
	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5},8));
	}
	static List<List<Integer>> outputList;
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		outputList=new ArrayList<>();
		List<Integer> list=new ArrayList<>();
		if(candidates==null||candidates.length==0)
			return outputList;
		Arrays.sort(candidates);
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
		int prev=-1;
		for (int i = index; i < candidates.length; i++) {
			if(prev!=candidates[i]){
				list.add(candidates[i]);
				dfs(sum+candidates[i], i+1, candidates, target, list);
				list.remove(list.size()-1);	
				prev=candidates[i];
			}
		}
	}
}

