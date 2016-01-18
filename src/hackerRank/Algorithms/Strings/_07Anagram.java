package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/anagram
 */
public class _07Anagram {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String inputString=scanner.nextLine();
			int length=inputString.length();
			int l1=length/2,l2=0;
			String s1=inputString.substring(0,l1);
			String s2=inputString.substring(l1);
			/*s1=sortString(s1);
			s2=sortString(s2);*/
			System.out.println(findAnagramLength(s1,s2));
		}
	}

	private static int findAnagramLength(String s1, String s2) {
		if(s1.length()!=s2.length())
			return -1;
		int noOfChanges=0;
		HashMap<Character, Integer> stringOneCharCount=new HashMap<>();
		HashMap<Character, Integer> stringTwoCharCount=new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char c1=s1.charAt(i);
			char c2=s2.charAt(i);
			if(stringOneCharCount.containsKey(c1))
			{
				stringOneCharCount.put(c1,stringOneCharCount.get(c1)+1);
			}
			else
			{
				stringOneCharCount.put(c1,1);
			}

			if(stringTwoCharCount.containsKey(c2))
			{
				stringTwoCharCount.put(c2,stringTwoCharCount.get(c2)+1);
			}
			else
			{
				stringTwoCharCount.put(c2,1);
			}
		}

		for (int i = 0; i < 26; i++) {
			char c=(char)(i+97);
			if(!stringOneCharCount.containsKey(c)){
				continue;
			}
			if(!stringTwoCharCount.containsKey(c)){
				stringTwoCharCount.put(c, 0);
			}
			noOfChanges+=(stringOneCharCount.get(c)-stringTwoCharCount.get(c))>0?stringOneCharCount.get(c)-stringTwoCharCount.get(c):0;
		}
		return noOfChanges;
	}
}
