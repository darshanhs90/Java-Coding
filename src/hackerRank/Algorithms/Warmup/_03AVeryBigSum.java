package hackerRank.Algorithms.Warmup;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/a-very-big-sum
*/
public class _03AVeryBigSum {

	public static void main(String args[])
	{
		Scanner scanner =new Scanner(new InputStreamReader(System.in));
		int N=Integer.parseInt(scanner.nextLine());
		String inputArray[]=scanner.nextLine().split(" ");
		Long sum=0l;
		for(int i=0;i<N;i++)
		{
			sum+=Long.parseLong(inputArray[i]);
		}
		System.out.println(sum);
	}
}
