package PracticeLeetCode;

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
	static List<List<String>> outputList;
	public static List<List<String>> partition(String s) {
		outputList=new ArrayList<>();
		if(s==null||s.length()==0)
			return outputList;
		List<String> list=new ArrayList<>();
		findPalindromes(s,list);
		return outputList;
	}
	private static void findPalindromes(String s,List<String> list) {
		if(s.length()==0)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		for (int i = 1; i <=s.length(); i++) {
			String sub=s.substring(0,i);
			if(isPalindrome(sub))
			{
				list.add(sub);
				findPalindromes(s.substring(i),list);
				list.remove(list.size()-1);
			}
		}
	}
	private static boolean isPalindrome(String sub) {
		int i=0,j=sub.length()-1;
		while(i<j)
		{
			if(sub.charAt(i)!=sub.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	

}