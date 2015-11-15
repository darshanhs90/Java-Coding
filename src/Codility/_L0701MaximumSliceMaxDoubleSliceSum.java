package Codility;

import java.util.Arrays;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/max_double_slice_sum
 */

public class _L0701MaximumSliceMaxDoubleSliceSum {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,2,6,-1,4,5,-1,2}));
	}
	public static int solution(int[] A){
		int[] A1=new int[A.length];
		int[] A2=new int[A.length];
		for (int i = 1; i < A.length-1; i++) {
			A1[i]=Math.max(A1[i-1]+A[i],0);
		}
		System.out.println(Arrays.toString(A1));
		for (int i = A.length-2; i >0; i--) {
			A2[i]=Math.max(A2[i+1]+A[i],0);
		}
		System.out.println(Arrays.toString(A2));
		int max=0;
		for (int i = 1; i < A2.length-1; i++) {
			max=Math.max(max,A1[i-1]+A2[i+1]);
		}
		return max;
	}
}