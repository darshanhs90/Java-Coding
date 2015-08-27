package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


/*
 * http://www.geeksforgeeks.org/amazon-interview/
 *  Check if a character link list is palindrome or not.
 */
public class _01AmazonInterview_2_2 {
	public static void main(String[] args) {
		LinkedList<Character> characterList=new LinkedList<Character>();
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString=scanner.nextLine();
		scanner.close();
		for (int i = 0; i < inputString.length(); i++) {
			characterList.add(inputString.charAt(i));
		}
		System.out.println("Character is a palindrome ? "+palindromeCheck(characterList));
	}

	private static boolean palindromeCheck(LinkedList<Character> characterList) {
		Stack<Character> stack=new Stack<Character>();
		for (int i = 0; i < characterList.size(); i++) {
			stack.push(characterList.get(i));
		}
		for (int i = 0; i < characterList.size()/2; i++) {
			if(stack.pop()!=characterList.get(i)){
				return false;
			}
		}
		return true;
	}
}
