package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14sherlockAndSquares {
	public static void main(String[] args) throws IOException {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		long T=Long.parseLong(scanner.readLine());
		for (long noOfTestCases = 0; noOfTestCases < T; noOfTestCases++) {
			String sline[]=scanner.readLine().split(" ");
			long A=Long.parseLong(sline[0]);
			long B=Long.parseLong(sline[1]);
			long count=0;
			for (long i = A; i <=B ; i++) {
				if(Math.ceil(Math.sqrt(i))==Math.floor(Math.sqrt(i)))
						count++;
			}
			System.out.println(count);
			
		}
	}
}
