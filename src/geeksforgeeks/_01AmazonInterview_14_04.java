package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-13-2/
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * Kadane's Algorithm
 */;
 public class _01AmazonInterview_14_04 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(new InputStreamReader(System.in));
		int size=Integer.parseInt(scanner.nextLine());
		scanner.close();
		int inputArray[]= new int[size];
		inputArray=buildArray(inputArray,inputArray.length);
		printArray(inputArray);
		System.out.println("Max Sum (Normal) is :"+findMaxSum(inputArray));
		System.out.println("Max Sum (Kadane) is :"+findMaxSumKadane(inputArray));
		
	}
	private static int findMaxSumKadane(int[] inputArray) {
		int max_so_far = 0,max_ending_here = 0;
		for (int i = 0; i < inputArray.length; i++) {
			max_ending_here+=inputArray[i];
			if(max_ending_here<0)
				max_ending_here=0;
			if(max_so_far<max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}
	private static int findMaxSum(int[] inputArray) {
		int sum=0;
		for (int i = 0; i < inputArray.length; i++) {
			sum+=inputArray[i];
			if(sum<0)
				sum=0;
		}
		return sum;
	}

	private static void printArray(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i]+",");
		}
		System.out.println();
	}

	private static int[] buildArray(int[] inputArray,int size) {
		for (int i = 0; i < inputArray.length; i++) {
			int value=new Random().nextInt(size*3);
			inputArray[i]=value%size==0?-1*value:value;
		}
		return inputArray;
	}

 }