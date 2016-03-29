package Warmup;

import java.util.Arrays;
import java.util.Stack;

public class _67ServiceNowPrep {
	public static void main(String[] args) {
		int[] arr=new int[]{1,0,3,5,0,0,34,5,0,36};
		arr=reverse(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] reverse(int[] arr) {
		Stack<Integer> stack=new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i]=stack.pop();
		}
		return arr;
	}


}






