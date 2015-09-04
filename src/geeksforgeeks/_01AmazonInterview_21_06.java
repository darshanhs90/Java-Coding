package geeksforgeeks;

import java.util.Arrays;
import java.util.Stack;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-21/
 * Print matrix spirally.
 * 1 2 3 4 5
 * 6 7 8 9 10
 * 11 12 13 14 15
 * 16 17 18 19 20
 * 21 22 23 24 25
 * O/P: 1 2 3 4 5 10 15 20 25 24 23 22 21 16 11 6 6 8 9 14 19 18 17 12 13 18
 */;
 public class _01AmazonInterview_21_06 {
	 public static void main(String[] args) {
		 int inputArray[][]={{1,2,3,4,5},
				 {6,7,8,9,10},
				 {11,12,13,14,15},
				 {16,17,18,19,20},
				 {21,22,23,24,25}};
		 printArray(inputArray);
		 System.out.println(printSpiralArray(inputArray));
	 }

	 private static String printSpiralArray(int[][] inputArray) {
		 int noOfRows=inputArray.length;
		 int noOfColumns=inputArray[0].length;
		 StringBuffer sb=new StringBuffer();
		 int topIndex=0,bottomIndex=noOfRows-1;
		 int leftIndex=0,rightIndex=noOfColumns;

		 for (int i = 0; i <= noOfColumns/2; i++) {
			 leftIndex=i;
			 rightIndex--;
			 Stack<Integer> stack=new Stack<Integer>();
			 for (int rowNumber = topIndex; rowNumber <=bottomIndex; rowNumber++) {
				 if(rowNumber==topIndex || rowNumber==bottomIndex){
					 for (int colNumber = leftIndex; colNumber <=rightIndex; colNumber++) {
						 if(rowNumber==topIndex)
							 sb.append(inputArray[rowNumber][colNumber]+" ");
						 else
							 stack.push(inputArray[rowNumber][colNumber]);
					 }
				 }
				 else{
					 stack.push(inputArray[rowNumber][leftIndex]);
					 sb.append(inputArray[rowNumber][rightIndex]+" ");	
				 }
			 }
			 while(!stack.isEmpty()){
				 sb.append(stack.pop()+" ");
			 }
			 topIndex++;
			 bottomIndex--;
		 }
		 return (sb.toString());
	 }

	 private static void printArray(int[][] inputArray) {
		 for (int i = 0; i < inputArray.length; i++) {
			 System.out.println(Arrays.toString(inputArray[i]));
		 }

	 }

 }
