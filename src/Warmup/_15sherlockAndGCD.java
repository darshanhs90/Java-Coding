package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15sherlockAndGCD {
	public static void main(String[] args) throws IOException {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		long T=Long.parseLong(scanner.readLine());
		for (long noOfTestCases = 0; noOfTestCases < T; noOfTestCases++) {
			long arraySize=Long.parseLong(scanner.readLine());
			long elementArray[]=new long[(int) arraySize];
			String strngArray[]=scanner.readLine().split(" ");
			for (int i = 0; i < elementArray.length; i++) {
				elementArray[i]=Long.parseLong(strngArray[i]);
			}
			//create subsets
			//check for divisibility condition for x>1 within the elements
			//3rd condition?
		}
	}
}
