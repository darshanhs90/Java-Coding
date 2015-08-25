package ctci;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;




/*Implementation of CTCI 2.7*/
public class _7LinkedList_6 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(new InputStreamReader(System.in));
		_2linkedList linkedList=new _2linkedList();
		System.out.println("Enter singly spaced elements");
		String inputStringArray[]=scanner.nextLine().split(" ");
		for (int i = 0; i < inputStringArray.length; i++) {
			linkedList.add(Integer.parseInt(inputStringArray[i]));
		}
		scanner.close();
		System.out.println("Linked List palindrome check using Stack is : "+checkPalindromeStack(linkedList));
		System.out.println("Linked List palindrome check using Longer Method is : "+checkPalindromeLonger(linkedList));

	}

	private static boolean checkPalindromeStack(_2linkedList linkedList) {
		Stack<Integer> stack=new Stack<Integer>();
		for (int i = 0; i < linkedList.size(); i++) {
			stack.push(linkedList.get(i));
		}
		for (int i = 0; i < linkedList.size(); i++) {
			if(stack.pop()!=linkedList.get(i))
				return false;
		}
		return true;
	}

	private static boolean checkPalindromeLonger(_2linkedList linkedList) {
		for (int i = 0; i < linkedList.size()/2; i++) {
			if(linkedList.get(i)!=linkedList.get(linkedList.size()-i-1))
				return false;
		}
		return true;
	}


}
