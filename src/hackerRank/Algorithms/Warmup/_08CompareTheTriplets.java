package hackerRank.Algorithms.Warmup;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/time-conversion
 */
public class _08CompareTheTriplets {
	public static void main(String args[])
	{
		Scanner scanner =new Scanner(System.in);
		int a0=scanner.nextInt();
		int a1=scanner.nextInt();
		int a2=scanner.nextInt();
		int b0=scanner.nextInt();
		int b1=scanner.nextInt();
		int b2=scanner.nextInt();
		int aScore=0,bScore=0;
		if(a0>b0)
			aScore++;
		else if(a0<b0)
			bScore++;
		if(a1>b1)
			aScore++;
		else if(a1<b1)
			bScore++;
		if(a2>b2)
			aScore++;
		else if(a2<b2)
			bScore++;
		System.out.println(aScore+" "+bScore);
	}
}
