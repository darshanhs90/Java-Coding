package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/alternating-characters
 */
public class _03AlternatingCharacters {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int k = 0; k < noOfTestCases; k++) {
			String inputString=scanner.nextLine();
			int noOfDeletions=0;
			char initialChar=inputString.charAt(0);
			for (int i = 1; i < inputString.length(); i++) {
				while(i<inputString.length() && inputString.charAt(i)==initialChar)
				{
					noOfDeletions++;
					i++;
				}
				if(i<inputString.length())
					initialChar=inputString.charAt(i);
			}
			System.out.println(noOfDeletions);
		}
	}
}
