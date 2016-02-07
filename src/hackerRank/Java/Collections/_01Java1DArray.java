package hackerRank.Java.Collections;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-1d-array-easy
 */

public class _01Java1DArray {
	public static void main(String []argv)
	{
		Scanner scanner=new Scanner(System.in);
		int noOfElements=scanner.nextInt();
		int inputArray[]=new int[noOfElements];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i]=scanner.nextInt();
		}
		int count=0;
		for (int i = 0; i < inputArray.length; i++) {
			int sum=0;
			for (int j = i; j < inputArray.length; j++) {
				sum+=inputArray[j];
				if(sum<0)
					count++;
			}
		}
		System.out.println(count);
	}
}
