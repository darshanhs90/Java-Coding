package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/pseudo-isomorphic-substrings
 * Use longest common prefix array
 */
public class _18PseudoIsomorphicSubstrings {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString="abbabab";//scanner.nextLine().trim();
		findIsomorphicSetCount(inputString);
	}

	private static void findIsomorphicSetCount(String inputString) {
		for (int i = 0; i < inputString.length(); i++) {
			String subString=inputString.substring(0, i+1);
			printIsomorphicSet(subString);
		}
	}

	private static void printIsomorphicSet(String subString) {
		
		
	}


}
