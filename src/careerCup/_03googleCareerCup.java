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

	private static int findLength(String inputString) {
		Stack<Character> charStack=new Stack<Character>();
		int count=0,maxCount=0;
		for (int i = 0; i < inputString.length(); i++) {
			char element=inputString.charAt(i);
			if(element=='(')
				charStack.push(element);
			else{
				if(!charStack.isEmpty() && charStack.pop()=='(')
				{
					count+=2;
				}
				else{
					charStack=new Stack<Character>();
					if(count>maxCount)
						maxCount=count;
					count=0;
				}
			}
			
		}
		return count>maxCount?count:maxCount;
	}
}
