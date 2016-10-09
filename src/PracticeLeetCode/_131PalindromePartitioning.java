package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _131PalindromePartitioning {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(partition("aab"));
	}
	public static List<List<String>> partition(String s) {
		List<List<String>> outputList=new ArrayList<>();
		if(s==null||s.length()==0)
			return outputList;
		List<String> list=new ArrayList<>();
		dfs(0,s,list,outputList);
		return outputList;
	}
	private static void dfs(int start, String s, List<String> list, List<List<String>> outputList) {
		if(start>s.length())
		{
			return;
		}
		if(start==s.length())
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = start+1; i <=s.length(); i++) {
			String str=s.substring(start,i);
			if(isPalindrome(str))
			{
				list.add(str);
				dfs(i, s, list, outputList);
				list.remove(list.size()-1);
			}
		}
	}
	private static boolean isPalindrome(String s) {
		return s.contentEquals(new StringBuilder(s).reverse().toString());
	}

}