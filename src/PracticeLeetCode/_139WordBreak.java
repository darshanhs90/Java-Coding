package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _139WordBreak {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		List<String> set=new ArrayList<>();
		set.add("leet");
		set.add("code");
		System.out.println(wordBreak("leetcode", set));
		set=new ArrayList<>();
		set.add("aaa");
		set.add("aaaa");
		System.out.println(wordBreak("aaaaaaa", set));
	}
	public static boolean wordBreak(String s, List<String> wordDict) {
		if(s==null||s.length()==0)
			return true;
		return dfs(0,s,wordDict);
	}
	private static boolean dfs(int i, String s, List<String> wordDict) {
		if(i<0||i>s.length())
			return false;
		if(i==s.length())
			return true;
		for (int j = i; j < s.length(); j++) {
			String str=s.substring(i,j+1);
			if(wordDict.contains(str) && dfs(j+1,s,wordDict))
				return true;
		}
		return false;
	}
}