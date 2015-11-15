package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/max_profit
 */

public class _L0702MaximumSliceMaxProfit {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{23171,21011,21123,21366,21013,21367}));
	}
	public static int solution(int[] A){
		int maxSoFar=0,minPrice=A[0],maxEndingHere=0;
		for (int i = 1; i < A.length; i++) {
			maxEndingHere=Math.max(0,A[i]-minPrice);
			minPrice=Math.min(minPrice,A[i]);
			maxSoFar=Math.max(maxEndingHere,maxSoFar);
		}		
		return maxSoFar;
	}
}