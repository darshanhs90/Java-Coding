package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/game-of-thrones
 */
public class _04GameOfThrones1 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString=scanner.nextLine();
		char[] chars = inputString.toCharArray();
		Arrays.sort(chars);
		inputString = new String(chars);
		boolean oddPresent=false;
		HashMap<Character, Integer> charCount=new HashMap<>();
		StringBuilder newString=new StringBuilder();
		for (int i = 0; i < inputString.length(); i++) {
			if(charCount.containsKey(inputString.charAt(i)))
			{
				charCount.put(inputString.charAt(i), charCount.get(inputString.charAt(i))+1);
			}
			else
			{
				charCount.put(inputString.charAt(i), 1);
				newString.append(inputString.charAt(i));
			}
		}
		for (int i = 0; i < newString.length(); i++) {
			if(charCount.get(newString.charAt(i))%2!=0 && oddPresent)
			{
				System.out.println("NO");
				System.exit(0);
			}
			else if(charCount.get(newString.charAt(i))%2!=0){
				oddPresent=true;
			}
		}
		System.out.println("YES");
	}
}
