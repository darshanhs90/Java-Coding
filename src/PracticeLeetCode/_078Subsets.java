package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _078Subsets {
	public static void main(String[] args) {
		System.out.println(subsets(new int[]{1,2,3}));
	}
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(nums==null||nums.length==0)
			return outputList;
		List<Integer> list=new ArrayList<>();
		for (int i = 0; i <=nums.length; i++) {
			dfs(nums,nums.length,i,0,outputList,list);
		}
		return outputList;
	}
	private static void dfs(int[] nums,int n, int k, int index, List<List<Integer>> outputList, List<Integer> list) {
		if(list.size()==k)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(nums, n, k, i+1, outputList, list);
			list.remove(list.size()-1);
		}
	}
}
