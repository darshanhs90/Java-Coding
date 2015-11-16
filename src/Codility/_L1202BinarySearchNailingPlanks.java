package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/nailing_planks
 */

public class _L1202BinarySearchNailingPlanks {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,4,5,8},new int[]{4,5,9,10},new int[]{4,6,7,10,2}));
	}
	public static int solution(int[] A, int[] B, int[] C){
		int count=0,N=B.length;
		for (int i = 0; i < C.length; i++) {
			if(C[i]<=B[count] && C[i]>=A[count])
			{
				count++;
				i--;
			}
			if(count==B.length)
				break;
		}		
		return count;
	}

}