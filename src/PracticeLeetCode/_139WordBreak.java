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
	private static boolean dfs(int index, String s, List<String> wordDict) {
		if(index>s.length())
			return false;
		if(index==s.length())
			return true;
		for (int i = index+1; i <=s.length(); i++) {
			String sub=s.substring(index,i);
			if(wordDict.contains(sub) && dfs(i,s,wordDict))
				return true;
		}
		return false;
	}
}