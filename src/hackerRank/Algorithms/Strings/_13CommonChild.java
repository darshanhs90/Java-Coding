package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/the-love-letter-mystery
 */
public class _13CommonChild {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		System.out.println(findCommonChild(scanner.nextLine(),scanner.nextLine()));
	}
	private static int findCommonChild(String inputString1, String inputString2) {
		return lcs(inputString1.toCharArray(),inputString2.toCharArray(),inputString1.length(),inputString2.length());
	}
	private static int lcs(char[] inputString1, char[] inputString2, int length1, int length2) {
		if(length1==0||length2==0)
			return 0;
		if(inputString1[length1-1]==inputString2[length2-1])
			return 1+lcs(inputString1,inputString2,length1-1,length2-1);
		else
			return Math.max(lcs(inputString1,inputString2,length1,length2-1), lcs(inputString1,inputString2,length1-1,length2));
	}



	//Doesnt consider the ordering of the sequences
	/*private static int findCommonChild(String inputString1, String inputString2) {
		int count=0;
		HashMap<Character, Integer> charCount1=new HashMap<>();
		HashMap<Character, Integer> charCount2=new HashMap<>();
		for (int i = 0; i < inputString1.length(); i++) {
			char c1=inputString1.charAt(i);
			char c2=inputString2.charAt(i);
			if(charCount1.containsKey(c1))
				charCount1.put(c1, charCount1.get(c1)+1);
			else
				charCount1.put(c1, 1);

			if(charCount2.containsKey(c2))
				charCount2.put(c2, charCount2.get(c2)+1);
			else
				charCount2.put(c2, 1);
		}
		for (int i = 65; i <=90; i++) {
			char c=(char)i;
			if(charCount1.containsKey(c) && charCount2.containsKey(c))
			{
				count+=Math.min(charCount1.get(c), charCount2.get(c));
			}
		}
		return count;
	}
	 */

}
