package LeetCodePerformancePractice;

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
		outputList.add(new ArrayList<>(list));
		for (int i = 0; i < nums.length; i++) {
			getCombinations(nums,nums.length,i+1,0,list,outputList);
		}
		return outputList;

	}
	

	private static void getCombinations(int[] nums, int n, int k,int index, List<Integer> list,
			List<List<Integer>> outputList) {
		if(n<k )
			return;
		if(list.size()==k)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			getCombinations(nums, n, k, i+1,list, outputList);
			list.remove(list.size()-1);
		}

	}
}
