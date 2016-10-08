package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _077Combinations {
	public static void main(String[] args) {
		System.out.println(combine(4,2));
	}
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(n==0)
			return outputList;
		List<Integer> list=new ArrayList<>();
		dfs(n,k,1,outputList,list);
		return outputList;
	}
	private static void dfs(int n, int k, int index, List<List<Integer>> outputList, List<Integer> list) {
		if(list.size()==k)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i <=n; i++) {
			list.add(i);
			dfs(n, k, i+1, outputList, list);
			list.remove(list.size()-1);
		}
		
	}
}
