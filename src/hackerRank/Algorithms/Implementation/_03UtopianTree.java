package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/sherlock-and-the-beast
 */
public class _03UtopianTree {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for(int i=0;i<noOfTestCases;i++)
		{
			int N=Integer.parseInt(scanner.nextLine());
			int height=0;
			int count=0;
			while(count<=N)
			{	
				
				if((count)%2!=0)
					height*=2;
				else
					height+=1;
				count++;
			}
			System.out.println(height);
		}
	}
}
