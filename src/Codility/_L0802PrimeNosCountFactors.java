package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/min_perimeter_rectangle
 */

public class _L0802PrimeNosCountFactors {
	public static void main(String[] args) {
		System.out.println(solution(60));
	}
	public static int solution(int N){
		int count=0;
		for (int i = 1; i*i <=N; i++) {
			if(N%i==0)
			{
				count++;
				count++;				
			}
		}
		
		return count;
	}
}