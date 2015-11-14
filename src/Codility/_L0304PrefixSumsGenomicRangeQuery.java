package Codility;

import java.util.Arrays;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/genomic_range_query
 */

public class _L0304PrefixSumsGenomicRangeQuery {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("CAGCCTA",new int[]{2,5,0},new int[]{4,5,6})));
	}
	public static  int[] solution(String S, int[] P, int[] Q){
		for (int i = 0; i < P.length; i++) {
			P[i]=getMinimum(S.substring(P[i],Q[i]));
		}
		return P;
	}
	private static int getMinimum(String str) {
		if(str.contains("A"))
			return 1;
		else if(str.contains("G"))
			return 2;
		else if(str.contains("C"))
			return 3;
		else 
			return 4;
	}
}