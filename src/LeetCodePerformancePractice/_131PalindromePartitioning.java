package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

public class _131PalindromePartitioning {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(partition("aab"));
	}
	public static List<List<String>> partition(String s) {
		List<List<String>> outputList=new ArrayList<>();
		if(s==null||s.length()==0)
			return outputList;
		List<String> list=new ArrayList<>();
		getCombinations(s,0,list,outputList);
		return outputList;
	}
	private static void getCombinations(String s, int start, List<String> list, List<List<String>> outputList) {
		if(start>s.length())
			return;
		if(start==s.length())
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = start+1; i <=s.length(); i++) {
			String string=s.substring(start,i);
			if(isPalindrome(string)){
				list.add(string);
				getCombinations(s, i, list, outputList);
				list.remove(list.size()-1);
			}
		}
	}
	private static boolean isPalindrome(String string) {
		int start=0,end=string.length()-1;
		while(start<end)
		{
			if(string.charAt(start)!=string.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}


}