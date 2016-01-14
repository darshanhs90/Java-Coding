package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/gem-stones
 */
public class _05Gemstones {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		HashMap<Character, Integer> charCount=new HashMap<>();
		int gemStones=0;
		for (int i = 0; i < noOfTestCases; i++) {
			String inputString=scanner.nextLine();
			for (int j = 0; j < inputString.length(); j++) {
				char c=inputString.charAt(j);
				if(charCount.containsKey(c) && charCount.get(c)==i)
				{
					charCount.put(c, i+1);
				}
				else if(!charCount.containsKey(c))
				{
					charCount.put(c, 1);
				}
			}
		}
		Object valueArray[]=charCount.values().toArray();
		for (int i = 0; i < valueArray.length; i++) {
			if((int)valueArray[i]==noOfTestCases)
				gemStones++;
		}
		System.out.println(gemStones);
	}
}
