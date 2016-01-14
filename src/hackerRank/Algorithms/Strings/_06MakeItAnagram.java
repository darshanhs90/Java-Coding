package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/make-it-anagram
 */
public class _06MakeItAnagram {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString1=scanner.nextLine();
		String inputString2=scanner.nextLine();
		int noOfDeletions=0;
		inputString1=sortString(inputString1);
		inputString2=sortString(inputString2);
		while(inputString1.length()>0 && inputString2.length()>0)
		{	
			char c1=inputString1.charAt(0);
			char c2=inputString2.charAt(0);
			if(c1>c2)
			{
				inputString2=inputString2.replaceFirst(c2+"","");
				noOfDeletions++;
			}
			else if(c1<c2)
			{
				inputString1=inputString1.replaceFirst(c1+"", "");
				noOfDeletions++;
			}
			else{
				inputString1=inputString1.replaceFirst(c1+"", "");
				inputString2=inputString2.replaceFirst(c1+"", "");
			}
		}
		if(inputString1.length()>0)
		{
			noOfDeletions+=inputString1.length();
		}
		else{
			noOfDeletions+=inputString2.length();
		}
		System.out.println(noOfDeletions);
	}

	private static String sortString(String inputString) {
		char[] stringArray=inputString.toCharArray();
		Arrays.sort(stringArray);
		inputString=new String(stringArray);
		return inputString;
	}
}
