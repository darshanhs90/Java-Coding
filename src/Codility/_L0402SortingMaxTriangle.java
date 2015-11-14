package Codility;

import java.util.Arrays;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/triangle
 */

public class _L0402SortingMaxTriangle {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{10,2,5,1,8,20}));
	}
	public static int solution(int[] A){
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		for (int i = 0; i < A.length-2; i++) {
			if(A[i]+A[i+1]>A[i+2]){
				System.out.println(i);
				return 1;
			}
		}
		return 0;
	}
}