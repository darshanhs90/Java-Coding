package hackerRank.Java.Strings;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-strings-introduction
 */

public class _01JavaStringsIntroduction {

	public static void main(String []argv)
	{
		Scanner scanner=new Scanner(System.in);
		String A=scanner.next();
		String B=scanner.next();
		System.out.println(A.length()+B.length());
		if(A.compareTo(B) > 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		System.out.println((A.charAt(0)+"").toUpperCase() + A.substring(1) + " " + (B.charAt(0)+"").toUpperCase() + B.substring(1));
	}
}
