package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _187RepeatedDNASequences {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> list=new ArrayList<>();
		if(s.length()<=10)
			return list;
		Set<String> set=new HashSet<String>();
		for (int i = 0; i <=s.length()-10; i++) {
			String str=s.substring(i,i+10);
			if(set.contains(str) && !list.contains(str))
				list.add(str);
			else{
				set.add(str);
			}
		}
		return list;
	}
}