package PracticeLeetCode;

import java.util.HashSet;
import java.util.Set;

public class _139WordBreak {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		Set<String> set=new HashSet<>();
		set.add("leet");
		set.add("code");
		System.out.println(wordBreak("leetcode", set));
		set=new HashSet<>();
		set.add("aaa");
		set.add("aaaa");
		System.out.println(wordBreak("aaab", set));
	}
a
	public static boolean wordBreak(String s, Set<String> wordDict) {
		if(s==null||s.length()==0)
			return false;
		return checkWordBreak(0,s,wordDict);
	}

	private static boolean checkWordBreak(int i, String s, Set<String> wordDict) {
		if(i>s.length())
			return false;
		if(i==s.length())
			return true;
		for (int j = i+1; j <=s.length(); j++) {
			String str=s.substring(i,j);
			if(wordDict.contains(str) && checkWordBreak(j, s, wordDict)){
				return true;
			}
		}
		return false;
	}
}