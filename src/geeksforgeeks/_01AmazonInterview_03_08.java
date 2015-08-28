package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-2/
 * You are given an array.
 * For every element you have to replace it with the closest number on the right side which is greater than the element itself.
 */
public class _01AmazonInterview_03_08 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int k=Integer.parseInt(scanner.nextLine());
		scanner.close();
		int inputArray[]=new int[k];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i]=new Random().nextInt(100);
		}
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i] +" ");
		}
		inputArray=replaceArray(inputArray);
		System.out.println();
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i] +" ");
		}
	}

	private static int[] replaceArray(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i]=findNearMax(inputArray,i);
		}
		return inputArray;
	}

	private static int findNearMax(int[] inputArray, int i) {
		int mainElement=inputArray[i];
		int element=Integer.MIN_VALUE;
		int diff=Integer.MAX_VALUE;
		for (int j = i+1; j < inputArray.length; j++) {
			if(inputArray[j]>mainElement){
				if(diff>(-mainElement+inputArray[j])){
					diff=-mainElement+inputArray[j];
					element=inputArray[j];
				}
			}
		}
		return element==Integer.MIN_VALUE?mainElement:element;
	}

}