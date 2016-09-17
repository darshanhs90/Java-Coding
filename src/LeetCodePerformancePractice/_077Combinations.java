package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

public class _077Combinations {
	public static void main(String[] args) {
		System.out.println(combine(4,2));
	}
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(n<=0||n<k)
			return outputList;
		List<Integer> list=new ArrayList<>();
		dfs(n,k,1,list,outputList);
		return outputList;
	}
	private static void dfs(int n, int k,int start, List<Integer> list, List<List<Integer>> outputList) {
		if(list.size()==k)
		{
			outputList.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i <=n; i++) {
			list.add(i);
			dfs(n,k,i+1,list,outputList);
			list.remove(list.size()-1);
		}
	}
}
