package hackerRank.CrackingTheCodingInterview;

import java.util.Arrays;
import java.util.Scanner;

public class _02MakingAnagrams {



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
	public static int numberNeeded(String first, String second) {
		char c[]=new char[26];
		for (int i = 0; i < first.length(); i++) {
			char c1=first.charAt(i);
			c[c1-97]++;
		}
		System.out.println(Arrays.toString(c));
		for (int i = 0; i < second.length(); i++) {
			char c1=second.charAt(i);
			if(c[c1-97]>0)
				c[c1-97]--;
			else
				c[c1-97]++;
		}		
		System.out.println(Arrays.toString(c));
		int count=0;
		for (int i = 0; i < c.length; i++) {
			count+=c[i];
		}		
		return count;
	}
}
