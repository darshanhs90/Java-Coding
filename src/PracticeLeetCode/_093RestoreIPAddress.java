package PracticeLeetCode;

import java.util.List;
import java.util.ArrayList;

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
		int length=s.length();
		if(s.length()>12)
    		return outputList;
		for (int i = 1; i <4 && i<length-2; i++) {
			for (int j = i+1; i <i+4 && j<length-1; j++) {
				for (int k = j+1; i <k+4 && k<length; k++) {
					String a=s.substring(0,i);
					String b=s.substring(i,j);
					String c=s.substring(j,k);
					String d=s.substring(k,length);
					if(isValid(a) && isValid(b)&& isValid(c)&& isValid(d))
					{
						outputList.add(a+"."+b+"."+c+"."+d);
					}
				}
			}
		}
		return outputList;
	}
	private static boolean isValid(String str) {
		if(str==null || str.length()==0)
			return false;
		if(str.length()>3||Integer.parseInt(str)>255||str.charAt(0)=='0'&&str.length()>1)
			return false;
		return true;
	}
}
