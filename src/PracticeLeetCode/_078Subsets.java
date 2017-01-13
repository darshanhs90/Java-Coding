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
			dfs(0,nums.length,i,list,outputList,nums);
		}

		return outputList;
	}

	private static void dfs(int index,int n, int k, List<Integer> list, List<List<Integer>> outputList,int nums[]) {
		if(list.size()==k)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i <nums.length; i++) {
			list.add(nums[i]);
			dfs(i+1,n,k,list,outputList,nums);
			list.remove(list.size()-1);
		}
	}
}
