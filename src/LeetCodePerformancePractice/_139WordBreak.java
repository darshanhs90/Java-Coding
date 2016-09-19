package LeetCodePerformancePractice;

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
			return true;
		return checkWordBreaking(s,0,wordDict);
	}
	private static boolean checkWordBreaking(String s, int start, Set<String> wordDict) {
		if(start>s.length())
			return false;
		if(start==s.length())
			return true;
		for (int i = start+1; i <=s.length(); i++) {
			String str=s.substring(start,i);
			if(wordDict.contains(str) && checkWordBreaking(s, i, wordDict))
			{
				return true;
			}
		}
		return false;
	}

}