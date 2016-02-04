package hackerRank.DataStructures.Arrays;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/arrays-ds
 */


public class _01ArraysDS {
	public static void main(String[] args) {

		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int N=Integer.parseInt(scanner.nextLine());
		int inputArray[]=new int[N];
		for (int i = 0; i < N; i++) {
			inputArray[i]=scanner.nextInt();
		}
		for (int i = inputArray.length-1; i >=0	; i--) {
			System.out.print(inputArray[i]+" ");
		}
	}
}
