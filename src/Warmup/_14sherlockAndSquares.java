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
			long startSquare=(long) Math.floor(Math.sqrt(A));
			if(Math.ceil(Math.sqrt(A))==startSquare)
				count++;
			long num=startSquare+1;
			while(true){
				long check=num*num;
				if(check>B)
					break;
				else{
					num++;
					count++;
				}
			}
			System.out.println(count);

		}
	}
}
