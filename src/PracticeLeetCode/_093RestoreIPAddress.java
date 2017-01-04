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
		System.out.println(restoreIpAddresses("10101010"));

	}
	public static List<String> restoreIpAddresses(String s) {
		List<String> list=new ArrayList<>();
		if(s==null||s.length()==0||s.length()>12)
			return list;
		for (int i = 1; i < i+4 && i<s.length(); i++) {
			for (int j = i+1; j < j+4 && j< s.length(); j++) {
				for (int k = j+1; k < k+4 && k<s.length(); k++) {
					String a=s.substring(0,i);
					String b=s.substring(i,j);
					String c=s.substring(j,k);
					String d=s.substring(k);
					if(isValid(a) && isValid(b) && isValid(c) && isValid(d))
					{
						list.add(a+"."+b+"."+c+"."+d);
					}
				}
			}
		}
		return list;
	}
	private static boolean isValid(String a) {
		if(a==null||a.length()==0||a.length()>3||a.length()>1 &&a.charAt(0)=='0' || Integer.parseInt(a)>255)
			return false;
		return true;
	}
}
