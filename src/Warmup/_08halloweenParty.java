package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _08halloweenParty {
	public static void main(String[] args) throws IOException {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		long T=Integer.parseInt(scanner.readLine());
		for (int noOfTestCases = 0; noOfTestCases < T; noOfTestCases++) {
			long K=Integer.parseInt(scanner.readLine());
			long tempVar1=K/2;
			long tempVar2=tempVar1;
			if((K)%2!=0)
				tempVar2+=1;
			System.out.println(tempVar1*tempVar2);
		}
	}
}
