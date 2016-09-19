package Warmup;

import java.util.Arrays;
import java.util.Comparator;

public class _80GoDaddyAssessment2 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(buildSubSequences("ba")));
		System.out.println(Arrays.toString(buildSubSequences("abc")));
	}
	static int counter=0;
	static String[] outputArray;
	private static String[] buildSubSequences(String string) {
		if(string==null||string.length()==0)
			return null;
		int n=string.length();
		outputArray=new String[(int) Math.pow(2, n)-1];
		counter=0;
		for (int i = 0; i <n; i++) {
			getCombinations(string,n,i+1,0,"");
		}
		Arrays.sort(outputArray,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}

		});
		return outputArray;
	}

	private static void getCombinations(String string, int n, int k, int index,String str) {
		if(n<k)
			return;
		if(str.length()==k)
		{
			System.out.println(str+"/"+counter);
			outputArray[counter]=str;
			counter++;
			return;
		}
		for (int i = index; i < string.length(); i++) {
			str+=string.charAt(i);
			getCombinations(string, n, k, i+1, str);
			str=str.substring(0,str.length()-1);
		}

	}

}