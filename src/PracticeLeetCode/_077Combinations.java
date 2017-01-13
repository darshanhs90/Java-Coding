package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _077Combinations {
	public static void main(String[] args) {
		System.out.println(combine(4,2));
	}
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(n<k)
			return outputList;
		List<Integer> list=new ArrayList<>();	
		dfs(1,n,k,list,outputList);
		return outputList;
	}
	private static void dfs(int index,int n, int k, List<Integer> list, List<List<Integer>> outputList) {
		if(list.size()==k)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i <=n; i++) {
			list.add(i);
			dfs(i+1,n,k,list,outputList);
			list.remove(list.size()-1);
		}
	}
}
