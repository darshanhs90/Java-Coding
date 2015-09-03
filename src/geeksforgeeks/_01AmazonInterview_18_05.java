package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



/*
 * http://www.geeksforgeeks.org/amazon-interview-set-18/
 * Given an array of numbers if we start deleting numbers from end of array,
 * then we have to tell the maximum element of the array after deletion in O(1).
 */;
 public class _01AmazonInterview_18_05 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 int size=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int inputArray[]=new int[size];
		 inputArray=buildArray(inputArray);
		 System.out.println(Arrays.toString(inputArray));		 
		 int maxArray[]=makeMaximumArray(inputArray);
		 System.out.println(Arrays.toString(maxArray));
		 removeElements(inputArray,maxArray);

	 }

	 private static void removeElements(int[] inputArray, int[] maxArray) {
		 int index=1;
		 while(inputArray.length>0){
			 System.out.println("removing "+inputArray[inputArray.length-1]);
			 inputArray=Arrays.copyOf(inputArray, inputArray.length-1);
			 maxArray=Arrays.copyOf(maxArray, maxArray.length-1);
			 if(maxArray.length>0)
				 System.out.println(maxArray[maxArray.length-1]);
			 index++;
		 }

	 }

	 private static int[] makeMaximumArray(int[] inputArray) {
		 int []maxArray=new int[inputArray.length];
		 int max=Integer.MIN_VALUE;
		 for (int i = 0; i <inputArray.length ; i++) {
			 maxArray[i]=inputArray[i]>max?inputArray[i]:max;
			 max=inputArray[i]>max?inputArray[i]:max;
		 }
		 return maxArray;
	 }

	 private static int[] buildArray(int[] inputArray) {
		 for (int i = 0; i < inputArray.length; i++) {
			 inputArray[i]=new Random().nextInt(inputArray.length*3);
		 }
		 return inputArray;
	 }
 }