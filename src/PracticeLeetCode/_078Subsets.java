package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _078Subsets {
	public static void main(String[] args) {
		System.out.println(subsets(new int[]{1,2,3}));
	}
	public static List<List<Integer>> subsets(int[] nums) {
		outputList=new ArrayList<>();
		if(nums==null||nums.length==0)
			return outputList;
		List<Integer> list=new ArrayList<>();
		for (int i = 0; i <=nums.length; i++) {
			dfs(0,nums,nums.length,i,list);
		}
		return outputList;
	}
	static List<List<Integer>> outputList;
	private static void dfs(int index,int[]nums,int n, int k, List<Integer> list) {
		if(index>n||list.size()>k)
			return;
		if(list.size()==k)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i<n; i++) {
			list.add(nums[i]);
			dfs(i+1,nums, n, k, list);
			list.remove(list.size()-1);
		}
	}
}
