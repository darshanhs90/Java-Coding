package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _26extraLongFactorials {
		public static void main(String[] args) throws Exception {
			BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
			int N=Integer.parseInt(scanner.readLine());
			BigInteger outputvalue=new BigInteger("1");
			for (int i = 1; i <= N; i++) {
				outputvalue=outputvalue.multiply(new BigInteger(String.valueOf(i)));
			}
			System.out.println(outputvalue);
		}
}
