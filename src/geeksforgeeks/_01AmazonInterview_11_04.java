package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;



/*
 * http://www.geeksforgeeks.org/amazon-interview-set-11/
 * Program to implement atoi function
 */;
 public class _01AmazonInterview_11_04 {
	 public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int size=Integer.parseInt(scanner.nextLine());
		scanner.close();
		int []inputArray=new int[size];
		for (int i = 0; i < size; i++) {
			inputArray[i]=new Random().nextInt(10);
		}
		printArray(inputArray);
		System.out.println("Integer value is :"+atoi(inputArray));
	}

	private static int atoi(int[] inputArray) {
		int output=0;
		int tenCount=1;
		for (int i = inputArray.length-1; i >=0; i--) {
			output+=inputArray[i]*tenCount;
			tenCount*=10;
		}
		return output;
	}

	private static void printArray(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i]+",");
		}
		System.out.println();
	}
 }