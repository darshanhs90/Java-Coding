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
		List<List<String>> outptutList=new ArrayList<>();
		if(s==null||s.length()==0)
			return outptutList;
		List<String> list=new ArrayList<>();
		dfs(0,s,list,outptutList);
		return outptutList;
	}
	private static void dfs(int i, String s, List<String> list, List<List<String>> outptutList) {
		if(i<0||i>s.length())
			return;
		if(i==s.length())
		{
			outptutList.add(new ArrayList<>(list));
			return ;
		}
		for (int j = i; j < s.length(); j++) {

			String str=s.substring(i,j+1);
			if(isValid(str))
			{
				list.add(str);
				dfs(j+1,s,list,outptutList);
				list.remove(list.size()-1);
			}
		}
	}
	private static boolean isValid(String str) {
		if(str==null||str.length()==0)
			return true;
		return str.contentEquals(new StringBuilder(str).reverse().toString());
	}


}