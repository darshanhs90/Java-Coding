package hackerRank.ProjectEuler;


import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/projecteuler/challenges/euler002
 */
public class _002EvenFibonacciNumbers {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			Long N=Long.parseLong(scanner.nextLine());
			long sum=0;
			long fib0=0,fib1=2;
			while(fib1<N){	
				sum+=fib1;
				long temp=fib1;
				fib1=4*fib1+fib0;
				fib0=temp;
			}
			System.out.println(sum);
		}
	}
}
