package hackerRank.Algorithms.DynamicProgramming;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/fibonacci-modified
 */
public class _01FibonacciModified {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		long n=scanner.nextInt();
		BigInteger fib[]=new BigInteger[(int) n];
		fib[0]=new BigInteger(a+"");fib[1]=new BigInteger(b+"");
		for (int i = 2; i < fib.length; i++) {
			fib[i]=(fib[i-1].multiply(fib[i-1])).add(fib[i-2]);
		}
		System.out.println(fib[fib.length-1]);
	}
}

