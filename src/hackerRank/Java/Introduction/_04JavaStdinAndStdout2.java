package hackerRank.Java.Introduction;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-stdin-stdout
 */

public class _04JavaStdinAndStdout2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=Integer.parseInt(sc.nextLine());
		double y=Double.parseDouble(sc.nextLine());
		String s=sc.nextLine();
		System.out.println("String: "+s);
		System.out.println("Double: "+y);
		System.out.println("Int: "+x);
	}
}
