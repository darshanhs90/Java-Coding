package servicenowPrep;

import java.util.Arrays;
import java.util.Stack;

public class _061ReverseArray
{

	public static void main(String[] args) {
		int[] arr=new int[]{1,0,3,5,0,0,34,5,0,36};
		arr=reverseArr(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] reverseArr(int[] arr) {
		Stack<Integer> stack=new Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i]=stack.pop();
		}
		return arr;
	}




}