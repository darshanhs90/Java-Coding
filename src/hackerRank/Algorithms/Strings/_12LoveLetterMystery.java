package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/the-love-letter-mystery
 */
public class _12LoveLetterMystery {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			System.out.println(findPalindromeChangeCount(scanner.nextLine().trim()));
		}
	}

	private static int findPalindromeChangeCount(String inputString) {
		int count=0;
		if(inputString.contentEquals(new StringBuilder(inputString).reverse().toString()))
			return 0;
		else{
			for (int i = 0; i <inputString.length()/2; i++) {
				if(inputString.charAt(i)!=inputString.charAt(inputString.length()-1-i))
				{
					count+=Math.abs(inputString.charAt(i)-inputString.charAt(inputString.length()-1-i));
				}
			}
		}
		return count;
	}
}
