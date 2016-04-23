package yelpInterview;

import java.util.Arrays;
import java.util.Stack;

public class _Array07ReverseArray {
	static int inputArray[];
	public static void main(String a[]){
		inputArray = new int[]{1, 2, 3, 4, 5, 6};
		System.out.println(Arrays.toString(inputArray));
		inputArray=reverseArray(inputArray);
		System.out.println(Arrays.toString(inputArray));
		reverseArrayRecusive(inputArray,0);
		System.out.println(Arrays.toString(inputArray));
	}
	private static void reverseArrayRecusive(int[] inputArray,int index) {
		if(index==inputArray.length-index-1 || index>(inputArray.length-1)/2)
			return;
		else{
			inputArray[index]=inputArray[inputArray.length-index-1] ^ inputArray[index];
			inputArray[inputArray.length-index-1]=inputArray[inputArray.length-index-1] ^ inputArray[index];
			inputArray[index]=inputArray[inputArray.length-index-1] ^ inputArray[index];
			reverseArrayRecusive(inputArray,index+1);
		}
	}
	private static int[] reverseArray(int[] inputArray) {
		Stack<Integer> arrayStack=new Stack<>();
		for (int i = 0; i < inputArray.length; i++) {
			arrayStack.push(inputArray[i]);
		}
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i]=arrayStack.pop();
		}
		return inputArray;
	}


}