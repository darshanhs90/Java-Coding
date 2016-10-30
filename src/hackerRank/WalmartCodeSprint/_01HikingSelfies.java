package hackerRank.WalmartCodeSprint;

import java.math.BigInteger;
import java.util.Scanner;

public class _01HikingSelfies{
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int x=scanner.nextInt();
		int sum=0;
		for (int i = 1; i <=n; i++) {
			sum+=CalculateCombinations(n,i);
		}
		System.out.println(Math.abs(sum-x));
	}

	private static int CalculateCombinations(int N, int K) {
		BigInteger ret = BigInteger.ONE;
		for (int k = 0; k < K; k++) {
			ret = ret.multiply(BigInteger.valueOf(N-k))
					.divide(BigInteger.valueOf(k+1));
		}
		return ret.intValue();
	}
}
