package PracticeLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		HashMap<String,Integer> set=new HashMap<>();
		for (int i = 0; i <=s.length()-10; i++) {
			String sub=s.substring(i,i+10);
			if(set.containsKey(sub))
			{
				set.put(sub, set.get(sub)+1);
			}
			else{
				set.put(sub,1);
			}
		}
		List<String> list=new ArrayList<>();
		for(Map.Entry entry : set.entrySet())
		{
			if((Integer)entry.getValue()>=2){
				list.add((String)entry.getKey());
			}
		}
		return list;
	}
}