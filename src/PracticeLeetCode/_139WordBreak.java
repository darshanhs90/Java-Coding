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
	public static boolean wordBreak(String s, Set<String> wordDict) {
		if(s==null||s.length()==0)
			return false;
		return wordBreak(0,s,wordDict);
	}
	private static boolean wordBreak(int index, String s, Set<String> wordDict) {
		if(index>s.length())
			return false;
		if(index==s.length())
			return true;
		for (int i = index; i < s.length(); i++) {
			String s1=s.substring(index,i+1);
			if(wordDict.contains(s1) && wordBreak(i+1, s, wordDict))
				return true;
		}
		return false;
	}
}