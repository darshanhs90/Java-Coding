package hackerRank.WalmartCodeSprint;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class _04PopsicleStickMountains{
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for (int i = 0;i<t;i++){
			int n=scanner.nextInt();
			System.out.println(findBraceCombinations(n));
		}
	}

	private static long findBraceCombinations(int n) {
		if(n<=1)
			return 0;
		n=n/2;
		if(n<=1)
			return 1;
		BigInteger[] mat=new BigInteger[n];
		BigInteger output=new BigInteger("1");
		mat[0]=new BigInteger("1");
		BigInteger count=new BigInteger("0");
		for (int i = 1; i <n; i++) {
			BigInteger temp=BigInteger.ONE.multiply(new BigInteger("2"));
			temp=temp.multiply(new BigInteger(((2*i)+1)+""));
			temp=temp.multiply(mat[i-1]);
			temp=temp.divide(new BigInteger((i+2)+""));
			mat[i]=temp;
			output=output.add(mat[i]);
		}
		//System.out.println(Arrays.toString(mat));
		output=output.mod(BigInteger.valueOf(1000000007));
		return output.longValue();
	}

	private static BigInteger findCombinations(int N, int K) {
		BigInteger ret = BigInteger.ONE;
		for (int k = 0; k < K; k++) {
			ret = ret.multiply(BigInteger.valueOf(N-k))
					.divide(BigInteger.valueOf(k+1));
		}
		ret=ret.divide(BigInteger.valueOf(K+1));
		ret.mod(BigInteger.valueOf(1000000007));
		return ret;
	}




}
