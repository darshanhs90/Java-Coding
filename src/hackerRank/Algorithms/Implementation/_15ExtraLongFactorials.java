package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/extra-long-factorials
 */
public class _15ExtraLongFactorials {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int N=Integer.parseInt(scanner.nextLine());
		BigInteger output=new BigInteger("1");
		for (int i = 1; i <=N; i++) {
			output=output.multiply(new BigInteger(i+""));
		}
		System.out.println(output.toString());
	}
}
