package hackerRank.Algorithms.Search;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/icecream-parlor
 */
public class _03MaximiseSum {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for(int i=0;i<noOfTestCases;i++)
		{
			int M=Integer.parseInt(scanner.nextLine());
			int N=Integer.parseInt(scanner.nextLine());
			String inputArray[]=scanner.nextLine().split(" ");
			String copyArray[]=Arrays.copyOf(inputArray,inputArray.length);
			Arrays.sort(copyArray);			
			int leftIndex=0,rightIndex=copyArray.length-1;
			while(leftIndex<rightIndex)
			{
				if((Integer.parseInt(copyArray[leftIndex])+Integer.parseInt(copyArray[rightIndex]))<M)            
				{
					leftIndex++;
				}
				else if((Integer.parseInt(copyArray[leftIndex])+Integer.parseInt(copyArray[rightIndex]))>M)            
				{
					rightIndex--;
				}
				else{
					break;
				}
			}
			int leftElement=Integer.parseInt(copyArray[leftIndex]);
			int rightElement=Integer.parseInt(copyArray[rightIndex]);
			leftIndex=-1;rightIndex=-1;
			for(int j=0;j<inputArray.length;j++)
			{
				if(Integer.parseInt(inputArray[j])==leftElement && leftIndex==-1)
					leftIndex=j;                
				else if(Integer.parseInt(inputArray[j])==rightElement && rightIndex==-1 )
					rightIndex=j; 
			}
			if(leftIndex<rightIndex)
				System.out.println((leftIndex+1)+" "+(rightIndex+1));
			else
				System.out.println((rightIndex+1)+" "+(leftIndex+1));
		}
	}
}
