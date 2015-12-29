package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/cut-the-sticks
 */
public class _07CutTheSticks {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int N=Integer.parseInt(scanner.nextLine());
		String inputArray[]=scanner.nextLine().split(" ");
		int numberArray[]=new int[inputArray.length];
		for (int i = 0; i < numberArray.length; i++) {
			numberArray[i]=Integer.parseInt(inputArray[i]);
		}
		while(true)
		{
			int min=findMin(numberArray);
			if(min!=Integer.MAX_VALUE)
			{
				numberArray=decreaseMin(numberArray,min);
			}
			else{
				break;
			}
		}
	}

	private static int[] decreaseMin(int[] numberArray, int min) {
		int count=0;
		for (int i = 0; i < numberArray.length; i++) {
			if(numberArray[i]!=0)
			{
				numberArray[i]-=min;
				count++;
			}
		}
		System.out.println(count);
		return numberArray;
	}

	private static int findMin(int[] numberArray) {
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < numberArray.length; i++) {
			if(numberArray[i]!=0 && numberArray[i]<min)
				min=numberArray[i];
		}
		return min;
	}
}
