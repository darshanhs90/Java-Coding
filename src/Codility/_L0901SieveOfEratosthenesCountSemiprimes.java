package Codility;

import java.util.Arrays;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/count_semiprimes
 */

public class _L0901SieveOfEratosthenesCountSemiprimes {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(26,new int[]{1,4,16},new int[]{26,10,20})));
	}
	public static int[] solution(int N, int[] P, int[] Q)
	{
		boolean prime[]=new boolean[N+1];
		boolean semi[]=new boolean[N+1];

		Arrays.fill(prime,true);
		for (int i = 2; i <=Math.sqrt(N); i++) {
			if(prime[i])
			{
				int j=i*i;
				while(j<=N)
				{
					prime[j]=false;
					j+=i;
				}				
			}
		}

		for (int i = 2; i * i <= N; i++) {
			if (!prime[i]) 
				continue;
			for (int k = i * i; k <= N; k += i) {
				if (prime[k / i])
					semi[k] = true;
			}
		}
		int count=0;
		int[] countArr=new int[N+1];
		for (int i = 1; i <=N; i++) {
			if(semi[i]==true)
				count++;
			countArr[i]=count;
		}
		System.out.println(Arrays.toString(countArr));
		for (int i = 0; i < P.length; i++) {
			P[i]=Math.abs((countArr[P[i]-1]-countArr[Q[i]]));
		}
		return P;
	}




}