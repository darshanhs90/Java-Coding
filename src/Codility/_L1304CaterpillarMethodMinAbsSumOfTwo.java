package Codility;

import java.util.Arrays;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/min_abs_sum_of_two
 */

public class _L1304CaterpillarMethodMinAbsSumOfTwo {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,4,-3}));
	}
	public static  int solution(int[] A){
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		int l=0,r=A.length-1;
		int min=Math.abs(A[0]+A[0]);
		while(l<=r)//Similar to Binary search traversal
		{
			int lval=Math.abs(A[l]*2);
			int rval=Math.abs(A[r]*2);
			int both=Math.abs(A[l]+A[r]);
			if (lval < min){
				min = lval;
			}
			if (rval < min){
				min = rval;
			}
			if (both < min){
				min = both;
			} 
			if (A[l] >= 0){
				break;    
			}
			if (lval < rval){
				r--;
			}
			else if (lval > rval){
				l++;
			}
			else {
				r--;
				l++;
			}
		}
		return min;
	}

}