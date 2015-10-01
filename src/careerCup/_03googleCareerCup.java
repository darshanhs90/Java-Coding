package careerCup;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/*
 * Link: http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 */
public class _03googleCareerCup {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString=scanner.nextLine();
		scanner.close();
		System.out.println(findLength(inputString));
	}

	private static char[] findLength(String inputString) {
		Stack<Character> charStack=new Stack<Character>();
		for (int i = 0; i < inputString.length(); i++) {
			
		}
		
		return null;
	}
}
