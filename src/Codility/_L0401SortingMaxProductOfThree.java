package Codility;

import java.util.Arrays;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/max_product_of_three
 */

public class _L0401SortingMaxProductOfThree {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{-3,1,2,-2,5,6}));
	}
	public static int solution(int[] A){
		Arrays.sort(A);
		int length=A.length;
		if((A[0]*A[1]*A[2])>(A[length-1]*A[length-2]*A[length-3]))
		{
			return (A[0]*A[1]*A[2]);
		}
		else{
			return (A[length-1]*A[length-2]*A[length-3]);
		}
	}
}