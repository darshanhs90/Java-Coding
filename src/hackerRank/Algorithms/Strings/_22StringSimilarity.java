package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/string-similarity
 */
public class _22StringSimilarity {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine().trim());
		for (int i = 0; i < noOfTestCases; i++) {
			String inputString=scanner.nextLine().trim();
			int similarity=0;
			for (int j = 0; j < inputString.length(); j++) {
				String substring=inputString.substring(j);
				similarity+=findSimilarity(inputString,substring);
			}
			System.out.println(similarity);
		}
	}

	private static int findSimilarity(String inputString, String substring) {
		int sim=0;
			for (int i = 0; i < substring.length(); i++) {
				if(inputString.charAt(i)==substring.charAt(i))
					sim+=1;
				else
					break;
			}
		return sim;
	}
}
