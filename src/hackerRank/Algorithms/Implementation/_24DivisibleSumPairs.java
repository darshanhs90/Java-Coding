package hackerRank.Algorithms.Implementation;

import java.util.Scanner;
/*
 * https://www.hackerrank.com/challenges/divisible-sum-pairs
 */
public class _24DivisibleSumPairs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int[] arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=scanner.nextInt();
		}
		int count=0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if((arr[i]+arr[j])%k==0)
					count++;
			}
		}
		System.out.println(count);
	}
}
