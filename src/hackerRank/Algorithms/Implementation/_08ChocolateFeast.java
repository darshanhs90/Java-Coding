package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/chocolate-feast
 */
public class _08ChocolateFeast {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for(int i=0;i<noOfTestCases;i++)
		{
			String inputArray[]=scanner.nextLine().split(" ");
			int N=Integer.parseInt(inputArray[0]);
			int C=Integer.parseInt(inputArray[1]);
			int M=Integer.parseInt(inputArray[2]);
			int noOfChocolates=N/C;
			int noOfWrappers=noOfChocolates;
			while(true)
			{
				if(noOfWrappers<M)
				{
					break;
				}
				else{
					int noOfNewChococolates=noOfWrappers/M;
					noOfChocolates+=noOfNewChococolates;
					int newWrappers=noOfWrappers%M;
					noOfWrappers=noOfNewChococolates+newWrappers;
				}
			}
			System.out.println(noOfChocolates);
		}
	}
}
