package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/sherlock-and-anagrams
 */
public class _09SherlockAndAnagrams {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String inputString=scanner.nextLine();
			System.out.println(findUnorderedAnagramPairs(inputString));
		}
	}

	private static int findUnorderedAnagramPairs(String inputString) {
		int count=0;
		while(inputString.length()>1) {
			for (int i = 1; i < inputString.length(); i++) {
				String mainString=inputString.substring(0, i);
				for (int j = 1; j <=inputString.length(); j++) {
					if((j+i)>inputString.length())
						continue;
					String comparisonString=inputString.substring(j, j+i);
					if(checkAnagram(mainString, comparisonString)){
						count++;
					}
				}
			}
			inputString=inputString.substring(1);
		}
		return count;
	}

	private static boolean checkAnagram(String mainString, String comparisonString) {
		if(sortString(mainString).contentEquals(sortString(comparisonString)))
			return true;
		return false;
	}

	private static String sortString(String inputString) {
		char[] chars=inputString.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

}
