package yelpInterview;

import java.util.Arrays;

public class _Array24TurnImage90Degrees {
	public static void main(String a[]){
		char [][]inputArray=new char[][]{{'*','*','*','^','*','*','*'},
			{'*','*','*','|','*','*','*'},
			{'*','*','*','|','*','*','*'},
			{'*','*','*','|','*','*','*'}};
			print(inputArray);
			inputArray=rotate(inputArray);
			print(inputArray);
	}

	private static char[][] rotate(char[][] inputArray) {
		char[][] outputArray=new char[inputArray[0].length][inputArray.length];
		for (int row = 0; row < inputArray.length; row++) {
			for (int col = 0; col < inputArray[0].length; col++) {
				outputArray[col][outputArray[0].length-row-1]=inputArray[row][col];
			}
		}
		
		
		return outputArray;
	}

	private static void print(char[][] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.println(Arrays.toString(inputArray[i]));
		}
	}




}