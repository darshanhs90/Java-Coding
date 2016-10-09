package PracticeLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
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
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
	}
	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> outputList=new ArrayList<String>();
		if(s==null||s.length()==0)
			return outputList;
		HashMap<String, Integer> strCount=new HashMap<>();
		for (int i = 0; i <=s.length()-10; i++) {
			String str=s.substring(i,i+10);
			if(strCount.containsKey(str))
			{
				if(strCount.get(str)==1)
				{
					outputList.add(str);
					strCount.put(str, 2);
				}
			}
			else{
				strCount.put(str, 1);
			}
		}
		return outputList;
	}
}