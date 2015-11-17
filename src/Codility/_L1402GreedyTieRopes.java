package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/tie_ropes
 */

public class _L1402GreedyTieRopes {
	public static void main(String[] args) {
		System.out.println(solution(4,new int[]{1,2,3,4,1,1,3}));
	}
	public static int solution(int K, int[] A){
		int count=0,sum=0;
		for (int i = 0; i < A.length; i++) {
			sum+=A[i];
			if(sum>=K){
				count++;
				sum=0;
			}
		}
		return count;
	}
}