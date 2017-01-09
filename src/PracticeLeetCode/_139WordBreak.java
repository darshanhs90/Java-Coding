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
		
	}
}