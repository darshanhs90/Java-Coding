package hackerRank.Java.Strings;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-string-reverse
 */

public class _03JavaStringReverse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String A=sc.nextLine();
		StringBuilder sb=new StringBuilder(A);
		sb.reverse();
		if(A.contentEquals(sb.toString()))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
