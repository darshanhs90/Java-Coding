package hackerRank.WeekOfCode34;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w30/challenges/candy-replenishing-robot
 */
public class _02MaximumGcdAndSum {

	static int maximumGcdAndSum(int[] A, int[] B) {
		HashMap<Integer, Integer> gcdSumMap=new HashMap<>();
		HashMap<Integer, Boolean> gcdSumMapFlag=new HashMap<>();
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			int x=A[i];
			for (int j = 0; j < B.length; j++) {
				int y=B[j];
				int gcd=gcd(x,y);
				max=Math.max(max, gcd);
				if(gcdSumMap.containsKey(gcd) && gcdSumMap.get(gcd)!=x+y){
					gcdSumMap.put(gcd, Math.max(x+y, gcdSumMap.get(gcd)));
					gcdSumMapFlag.put(gcd, true);
				}
				else{
					gcdSumMap.put(gcd, x+y);
					gcdSumMapFlag.put(gcd, false);
				}
			}
		}

		if(gcdSumMapFlag.get(max)==false){
			return gcdSumMap.get(max);
		}
		return max;
	}
	static int gcd(int n1,int n2){
		while(n1 != n2)
		{
			if(n1 > n2)
				n1 = n1-n2;
			else
				n2 = n2-n1;
		}
		return n1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for(int A_i = 0; A_i < n; A_i++){
			A[A_i] = in.nextInt();
		}
		int[] B = new int[n];
		for(int B_i = 0; B_i < n; B_i++){
			B[B_i] = in.nextInt();
		}
		int res = maximumGcdAndSum(A, B);
		System.out.println(res);
	}
}
