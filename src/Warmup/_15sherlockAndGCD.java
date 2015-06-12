package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
			Arrays.sort(elementArray);
			long divisor=elementArray[0];
			long count=0;
			if(divisor!=1)
			{
				//check if there is a gcd
			}
			if(count==elementArray.length-1){
				System.out.println("NO");
			}
			else{
				System.out.println("YES");
			}		}
	}
}
