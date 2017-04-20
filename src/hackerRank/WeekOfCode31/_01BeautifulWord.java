package hackerRank.WeekOfCode31;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w30/challenges/candy-replenishing-robot
 */
public class _01BeautifulWord {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String w = in.next();
		// Print 'Yes' if the word is beautiful or 'No' if it is not.
		boolean isVowel = isCharVowel(w.charAt(0));
		for (int i = 1; i < w.length(); i++) {
			char c=w.charAt(i);
			if(c==w.charAt(i-1))
			{
				System.out.println("No");
				System.exit(0);
			}
			else if(isCharVowel(c))
			{
				if(isVowel)
				{
					System.out.println("No");
					System.exit(0);
				}
				else{
					isVowel=true;
				}
			}
			else{
				isVowel=false;
			}
		}
		System.out.println("Yes");
	}

	private static boolean isCharVowel(char c) {
		return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='y';
	}
}

