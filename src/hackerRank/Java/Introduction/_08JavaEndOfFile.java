package hackerRank.Java.Introduction;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-end-of-file
 */

public class _08JavaEndOfFile {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int counter=0;
		while(scanner.hasNext())
		{
			String s=scanner.nextLine();
			counter++;
			System.out.println(counter+" "+s);
		}
	}
}
