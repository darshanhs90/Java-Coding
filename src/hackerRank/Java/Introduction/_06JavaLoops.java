package hackerRank.Java.Introduction;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-loops
 */

public class _06JavaLoops {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for(int i=0;i<noOfTestCases;i++)
		{
			String inputArray[]=scanner.nextLine().split(" ");
			int a=Integer.parseInt(inputArray[0]);
			int b=Integer.parseInt(inputArray[1]);
			int n=Integer.parseInt(inputArray[2]);
			int prev=a;
			for(int j=0;j<n;j++)
			{
				int value=prev+(int)Math.pow(2,j)*b;
				System.out.print(value+" ");
				prev=value;
			}
			System.out.println("");
		}
	}
}
