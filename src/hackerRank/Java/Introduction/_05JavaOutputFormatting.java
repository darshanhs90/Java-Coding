package hackerRank.Java.Introduction;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-output-formatting
 */

public class _05JavaOutputFormatting {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("================================");
		for(int i=0;i<3;i++)
		{
			String s1=sc.next();
			int x=sc.nextInt();
			System.out.printf("%-15s%03d",s1,x);
			System.out.println("");
		}
		System.out.println("================================");

	}
}
