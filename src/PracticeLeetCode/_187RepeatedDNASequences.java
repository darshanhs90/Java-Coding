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
		 List<String> outputList=new ArrayList<>();
		 if(s==null||s.length()<10)
			 return outputList;
		 HashMap<String, Integer> map=new HashMap<>();
		 for (int i = 0; i <=s.length()-10; i++) {
			String str=s.substring(i,i+10);
			if(map.containsKey(str))
			{
				map.put(str,2);
			}
			else{
				map.put(str, 1);
			}
		}
		for(Map.Entry<String, Integer> entry:map.entrySet()){
			if(entry.getValue()>1)
			{
				outputList.add(entry.getKey());
			}
		}
		return outputList;
	}
}