package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-8-2/
 * Given an array. Iterate it for the given number of times. And then return the summation of the resultant elements.
 * Ex: Array is { 1,2,5,6}, N=2
 * After 1st iteration: {2-1, 5-2, 6-5}={1,3,1}
 * After 2nd : {3-1, 1-3}={2,-2}
 * Sum is 2  + (-2) = 0
 * If only one element remains in the array, the element remains the same after applying the iteration. Complete the method.
 */;
 public class _01AmazonInterview_09_02 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 Integer size=Integer.parseInt(scanner.nextLine());
		 Integer noOfIterations=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int inputArray[]=new int[size];
		 inputArray=constructArray(size, inputArray);
		 System.out.println(Arrays.toString(inputArray));
		 System.out.println("Sum is : "+getSum(inputArray,noOfIterations));
	 }

	private static int getSum(int[] inputArray, Integer noOfIterations) {
		ArrayList<Integer> inputList=new ArrayList<Integer>();
		ArrayList<Integer> outputList=new ArrayList<Integer>();
		for (int i = 0; i < inputArray.length; i++) {
			inputList.add(inputArray[i]);
		}
		for (int i = 0; i < noOfIterations; i++) {
			if(inputList.size()==1)
				continue;
			for (int j = 0; j < inputList.size()-1; j++) {
				outputList.add(inputList.get(j+1)-inputList.get(j));
			}
			inputList=outputList;
			outputList=new ArrayList<Integer>();
		}
		return getSumFromList(inputList);
	}

	private static int getSumFromList(ArrayList<Integer> inputList) {
		int sum=0;
		for (int i = 0; i < inputList.size(); i++) {
			sum+=inputList.get(i);
		}
		return sum;
	}

	private static int[] constructArray(Integer size, int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i]=new Random().nextInt(size*3);
		}
		return inputArray;
	}

	
 }