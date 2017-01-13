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
		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(i, sum+candidates[i], candidates, target, list, outputList);
			list.remove(list.size()-1);
		}
	}
}

