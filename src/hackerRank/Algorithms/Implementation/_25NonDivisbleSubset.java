package hackerRank.Algorithms.Implementation;

import java.util.Arrays;
import java.util.Scanner;
/*
 * https://www.hackerrank.com/challenges/divisible-sum-pairs
 */
public class _25NonDivisbleSubset {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int arr[]=new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=scanner.nextInt();
		}
		int maxLength=0;
		for (int i = 0; i < arr.length-1; i++) {
			int array[]=Arrays.copyOfRange(arr, i, arr.length);
			if(Checksum(array))
				maxLength=array.length;
		}
	}

	private static boolean Checksum(int[] array) {
		
		return false;
	}
}
