package Codility;

import java.util.Arrays;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/ladder
 */

public class _L1101FibonacciLadder {
	public static void main(String[] args) {
		System.out.println(fibo(4));
		System.out.println(Arrays.toString(solution(new int[]{4,4,5,5,1}, new int[]{3,2,4,3,1})));
	}
	public static int[] solution(int[] A, int[] B){
		for (int i = 0; i < B.length; i++) {
			A[i]=(int) (fibo(A[i])%Math.pow(2,B[i]));//use fibo for long
		}
		return A;
	}
	private static int fibo(int i) {
		if(i==1||i==0)
			return 1;
		else
			return fibo(i-1)+fibo(i-2);
	}



}