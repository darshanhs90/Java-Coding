package hackerRank.Java.Strings;

import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * Link:https://www.hackerrank.com/challenges/pattern-syntax-checker
 */

public class _06PatternSyntaxChecker {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String pattern=scanner.nextLine();
			try{
				Pattern.compile(pattern);
				System.out.println("Valid");
			}
			catch(Exception e){
				System.out.println("Invalid");
			}
		}
	}
}
