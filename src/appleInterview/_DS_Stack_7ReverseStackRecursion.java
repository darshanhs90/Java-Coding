package appleInterview;

import java.util.Stack;

public class _DS_Stack_7ReverseStackRecursion {
	static Stack<Integer> stack=new Stack<>();
	public static void main(String[] args) {
		stack=new Stack<>();
		int[] arr=new int[]{1,2,3,4,5,6};
		populateStack(arr);
		//printStack();
		reverseStackUtil();
		printStack();
	}

	private static void printStack() {
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop()+" ");
		}

	}

	private static void populateStack(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}
	}

	private static void reverseStackUtil() {
		if(stack.isEmpty())
		{
			return;
		}
		else{
			int e=stack.pop();
			reverseStackUtil();
			insertBottom(e);
		}
	}
	private static void insertBottom(int element) {
		if(stack.isEmpty())
		{
			stack.push(element);
			return;
		}
		else{
			int e=stack.pop();
			insertBottom(element);
			stack.push(e);
		}
	}
}
