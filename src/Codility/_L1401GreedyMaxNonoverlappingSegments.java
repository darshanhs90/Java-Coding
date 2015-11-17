package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/max_nonoverlapping_segments
 */

public class _L1401GreedyMaxNonoverlappingSegments {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,3,7,9,9},new int[]{5,6,8,9,10}));
	}
	public static int solution(int[] A, int[] B){
		int count=1;
		int end=B[0];
		for (int i = 1; i < B.length; i++) {
			if(A[i]>end){
				count++;
				end=B[i];
			}
		}
		return count;
	}

}