package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _093RestoreIPAddress {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135"));
	}
	public static List<String> restoreIpAddresses(String s) {
		List<String> outputList=new ArrayList<>();
		if(s==null||s.length()==0||s.length()>12)
			return outputList;
		for (int i = 1; i < i+4 && i<s.length()-2; i++) {
			for (int j = i+1; j < i+4 && i<s.length()-1; j++) {
				for (int k = j+1; k < j+4 && k<s.length(); k++) {
					String a=s.substring(0,i);
					String b=s.substring(i,j);
					String c=s.substring(j,k);
					String d=s.substring(k,s.length());
					if(isValid(a) && isValid(b) && isValid(c) && isValid(d))
					{
						outputList.add(a+"."+b+"."+c+"."+d);
					}
				}
			}	
		}
		return outputList;
	}
	private static boolean isValid(String a) {
		if(a==null||a.length()<1||a.length()>3||Integer.parseInt(a)>255||
				a.length()>1 && a.charAt(0)=='0')
			return false;
		return true;
	}
}
