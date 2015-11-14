package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/count_div
 */

public class _L0301PrefixSumsCountDiv {

	public static void main(String[] args) {
		System.out.println(solution(6, 11, 2));
	}

	public static int solution(int A, int B, int K){
		int count=0;
		if(A%K==0)
			count=1;
		return (B-A)/K+count;
	}
}