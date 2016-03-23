package appleInterview;

import java.util.Stack;
/*
 * http://stackoverflow.com/questions/19720349/find-next-higher-element-in-an-array-for-each-element
*/
public class _DS_Stack_6NextGreaterElement {
	public static void main(String[] args) {
		int inputArray[]=new int[]{40,50,11,32,55,68,75};
		nextGreaterElement(inputArray);
	}

	private static void nextGreaterElement(int[] inputArray) {
		Stack<Integer> stack=new Stack<>();
		stack.push(inputArray[0]);
		for (int i = 1; i < inputArray.length; i++) {
			//	System.out.println(stack.peek()+"/"+inputArray[i]);
			if(stack.isEmpty())
			{
				stack.push(inputArray[i]);
			}
			else{
				while(!stack.isEmpty() && stack.peek()<inputArray[i])
				{
					System.out.println(stack.pop()+"->"+inputArray[i]);
				}
				stack.push(inputArray[i]);
			}
		}
		while(!stack.isEmpty())
			System.out.println(stack.pop()+"->-1");
	}
}
