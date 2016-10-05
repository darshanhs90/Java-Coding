package hackerRank.CrackingTheCodingInterview;

import java.util.Scanner;

public class _10BubbleSort {
	static int noOfSwaps=0;
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] inputArray=new int[n];
		for (int i = 0; i < n; i++) {
			inputArray[i]=scanner.nextInt();
		}
		inputArray=bubbleSort(inputArray);
		System.out.println("Array is sorted in "+noOfSwaps+" swaps.");
		System.out.println("First Element: "+inputArray[0]);
		System.out.println("Last Element: "+inputArray[inputArray.length-1]);
	}
	private static int[] bubbleSort(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i+1; j < inputArray.length; j++) {
				if(inputArray[i]>inputArray[j])
				{
					int temp=inputArray[i];
					inputArray[i]=inputArray[j];
					inputArray[j]=temp;
					noOfSwaps++;
				}
			}
		}
		return inputArray;
	}
}
