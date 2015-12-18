package hackerRank.Algorithms.Warmup;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/simple-array-sum
*/
public class _02SimpleArraySum {

	public static void main(String args[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		Integer N=Integer.parseInt(scanner.nextLine());
		String inputArray[]=scanner.nextLine().split(" ");
		int sum=0;
		for(int i=0;i<N;i++)
		{
			sum+=Integer.parseInt(inputArray[i]);
		}
		System.out.println(sum);
	}
}
