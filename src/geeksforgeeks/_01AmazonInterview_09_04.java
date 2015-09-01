package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-8-2/
 * Given an array of size N, move the first d elements to its last.
 * 3,5,34,49,91,110
 */;
 public class _01AmazonInterview_09_04 {
	 public static void main(String[] args) {
		 Scanner scanner=new  Scanner(new InputStreamReader(System.in));
		 int size=Integer.parseInt(scanner.nextLine());
		 int d=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int inputArray[]=new int[size];
		 inputArray=buildInputArray(inputArray);
		 printArray(inputArray);
		 inputArray=shiftinputArray(inputArray,d);
		 printArray(inputArray);
	 }

	 private static int[] shiftinputArray(int[] inputArray, int d) {
		 int[] outputArray=new int[inputArray.length];
		 int outputIndex=0;
		 for (int i = d; i < outputArray.length; i++) {
			 outputArray[outputIndex]=inputArray[i];
			 outputIndex++;
		 }
		 for (int i = 0; i < d; i++) {
			 outputArray[outputIndex]=inputArray[i];
			 outputIndex++;
		 } 
		 return outputArray;
	 }

	 private static void printArray(int[] inputArray) {
		 for (int i = 0; i < inputArray.length; i++) {
			 System.out.print(inputArray[i]+",");
		 }
		 System.out.println();
	 }

	 private static int[] buildInputArray(int[] inputArray) {
		 for (int i = 0; i < inputArray.length; i++) {
			 inputArray[i]=new Random().nextInt(inputArray.length*3);
		 }
		 return inputArray;
	 }


 }