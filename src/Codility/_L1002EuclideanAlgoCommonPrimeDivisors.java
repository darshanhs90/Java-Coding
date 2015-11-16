package Codility;

import java.util.ArrayList;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/common_prime_divisors
 */

public class _L1002EuclideanAlgoCommonPrimeDivisors {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{15,10,3},new int[]{75,30,5}));
	}
	public static int solution(int[] A, int[] B){
		int count=0;
		for (int i = 0; i < A.length; i++) {
			int M=A[i],N=B[i];
			if(M<N)
			{
				M=M^N;
				N=M^N;
				M=M^N;
			}
			ArrayList<Integer> longPrimeList=findPrimeFactors(M);
			ArrayList<Integer> shortPrimeList=findPrimeFactors(N);
			if(!(longPrimeList.size()!=shortPrimeList.size() || longPrimeList.size()==0||shortPrimeList.size()==0))
			{	
				boolean flag=true;
				for (int j = 0; j <shortPrimeList.size(); j++) {
					if(shortPrimeList.get(j)!=longPrimeList.get(j))
					{
						flag=false;
					}
				}
				if(flag)
					count++;
			}
		}
		return count;
	}
	private static ArrayList<Integer> findPrimeFactors(int M) {
		boolean b[]=new boolean[M+1];
		ArrayList<Integer> list=new ArrayList<>();
		for (int i = 2; i <Math.sqrt(M); i++) {
			if(!b[i])
			{
				int j=i*i;
				while(j<=M)
				{
					b[j]=true;
					j+=i;
				}	
			}
		}
		for (int i = 2; i<M; i++) {
			if(b[i]==false && M%i==0)
				list.add(i);
		}
		return list;
	}



}