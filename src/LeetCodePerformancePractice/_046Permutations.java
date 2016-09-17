package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

public class _046Permutations {
	public static void main(String[] args) {
		System.out.println(permute(new int[]{1,2,3}));
		permute1("","123");
	}
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(nums==null||nums.length==0)
			return outputList;
		List<Integer> list=new ArrayList<>();
		dfs(nums,0,list,outputList);
		return outputList;
	}
	private static void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> outputList) {
		if(list.size()>nums.length)
			return;
		if(list.size()==nums.length)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(nums, i+1, list, outputList);
			list.remove(list.size()-1);
		}

	}
	public static void permute1(String prefix,String str) {
		if(str.length()==0)
		{
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			permute1(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1));
		}
	}
}

