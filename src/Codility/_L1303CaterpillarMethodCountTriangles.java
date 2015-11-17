package Codility;

import java.util.Arrays;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/count_triangles
 */

public class _L1303CaterpillarMethodCountTriangles {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{10,2,5,1,8,12}));
	}
	public static int solution(int[] A){
		int count=0;
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		for (int i = 0; i <A.length-2; i++) {
			int k=i+2;
			for (int j = i+1; j < A.length; ++j)
			{
				while (k < A.length && A[i] + A[j] > A[k])
					++k;
				count += k - j - 1;
			}
		}

		return count;
	}

}