package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/two-strings
 */
public class _08TwoStrings {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String inputString1=scanner.nextLine();
			String inputString2=scanner.nextLine();
			System.out.println(checkMatch(inputString1,inputString2));
		}
	}

	private static String checkMatch(String inputString1, String inputString2) {
		for (int i = 0; i < 26; i++) {
			char c=(char)(i+97);
			if(inputString1.contains(c+"") && inputString2.contains(c+""))
				return "YES";
		}
		return "NO";
	}
}
