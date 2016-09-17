package Warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _79GoDaddyAssessment2 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(buildSubSequences("ba"));
		System.out.println(buildSubSequences("abc"));
		
	}
	private static List<String> buildSubSequences(String string) {
		List<String> outputList=new ArrayList<String>();
		if(string==null||string.length()==0)
			return outputList;
		int n=string.length();
		for (int i = 0; i <n; i++) {
			getCombinations(string,n,i+1,0,outputList,"");
		}
		outputList.add("");
		Collections.sort(outputList,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		return outputList;
	}
	
	private static void getCombinations(String string, int n, int k, int index, List<String> outputList,String str) {
		if(n<k)
			return;
		if(str.length()==k)
		{
			outputList.add(new String(str));
			return;
		}
		for (int i = index; i < string.length(); i++) {
			str+=string.charAt(i);
			getCombinations(string, n, k, i+1, outputList, str);
			str=str.substring(0,str.length()-1);
		}

	}

}