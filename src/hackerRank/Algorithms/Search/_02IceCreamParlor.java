package hackerRank.Algorithms.Search;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/icecream-parlor
 */
public class _02IceCreamParlor {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for(int i=0;i<noOfTestCases;i++)
		{
			int M=scanner.nextInt();//Integer.parseInt(scanner.nextLine());
			int N=scanner.nextInt();//Integer.parseInt(scanner.nextLine());
			int inputArray[]=new int[N];
			for (int j = 0; j < N; j++) {
				inputArray[j]=scanner.nextInt();
			}
			int copyArray[]=Arrays.copyOf(inputArray,inputArray.length);
			Arrays.sort(copyArray);		
			int leftIndex=0,rightIndex=copyArray.length-1;
			while(leftIndex<rightIndex)
			{
				if(((copyArray[leftIndex])+(copyArray[rightIndex]))<M)            
				{
					leftIndex++;
				}
				else if(((copyArray[leftIndex])+(copyArray[rightIndex]))>M)            
				{
					rightIndex--;
				}
				else{
					break;
				}
			}
			int leftElement=(copyArray[leftIndex]);
			int rightElement=(copyArray[rightIndex]);
			leftIndex=-1;rightIndex=-1;
			for(int j=0;j<inputArray.length;j++)
			{
				if((inputArray[j])==leftElement && leftIndex==-1)
					leftIndex=j;                
				else if((inputArray[j])==rightElement && rightIndex==-1 )
					rightIndex=j; 
			}
			if(leftIndex<rightIndex)
				System.out.println((leftIndex+1)+" "+(rightIndex+1));
			else
				System.out.println((rightIndex+1)+" "+(leftIndex+1));
		}
	}
}
