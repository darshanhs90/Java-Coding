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
	}
}