package hackerRank.Java.Collections;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/*
 * Link:https://www.hackerrank.com/challenges/java-stack
 */

public class _05JavaStack {
	public static void main(String[] args) {
		Scanner scanner=new Scanner((System.in));
		while(scanner.hasNext()){
			String inputString=scanner.nextLine();
			System.out.println(validateParentheses(inputString));
		}
	}

	private static boolean validateParentheses(String inputString) {
		Stack<Character> charStack=new Stack<>();
		for (int i = 0; i < inputString.length(); i++) {
			char indexedChar=inputString.charAt(i);
			if(indexedChar=='('||indexedChar=='['||indexedChar=='{')
			{
				charStack.push(indexedChar);
			}
			else{
				if(charStack.isEmpty())
					return false;
				else
				{
					char poppedChar=charStack.pop();
					if((indexedChar==']' && poppedChar=='[')
							||(indexedChar=='}' && poppedChar=='{')
							||(indexedChar==')' && poppedChar=='('))
						continue;
					else
						return false;
				}
			}
		}
		return charStack.isEmpty();
	}
}