package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/max_slice_sum
 * Kadane's Algorithm 
 */

public class _L0703MaximumSliceMaxSliceSum {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,2,-6,4,0}));
	}
	public static int solution(int[] A){
		int maxSoFar=A[0],maxEndingHere=A[0];
		for (int i = 1; i < A.length; i++) {
			maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
	        maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}		
		return maxSoFar;
	}
}