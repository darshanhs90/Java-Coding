package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/palindrome-index
 */
public class _10PalindromeIndex {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String inputString=scanner.nextLine().trim();
			if(new StringBuilder(inputString).toString().contentEquals(new StringBuilder(inputString).reverse().toString()))
			{
				System.out.println("-1");
			}
			else
			{
				System.out.println(findIndex(inputString));
			}
		}
	}

	private static int findIndex(String inputString) {
		for (int i = 0; i < inputString.length(); i++) {
			if(inputString.charAt(i)==inputString.charAt(inputString.length()-1-i))
				continue;
			else{
				inputString=inputString.substring(0,i)+inputString.substring(i+1);
				if(new StringBuilder(inputString).toString().contentEquals(new StringBuilder(inputString).reverse().toString()))
				{
					return (i);
				}
				else{
					return inputString.length()-i;
				}
			}
		}
		return 0;
	}
}
