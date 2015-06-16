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
				//check if there is a gcd,euclids algorithm
				//no gcd,print no,else yes
				long r=elementArray[0];
				for (int i = 1; i < elementArray.length; i++) {
					r=gcd(r,elementArray[i]);
				}
				if(r==1)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			else
				System.out.println("YES");


		}
	}
	
	
	public static long gcd(long m,long n){
		
		long r=m%n;
		//System.out.println(r);
		if(r==0)
			return n;
		else
		{
			m=n;
			n=r;
			return gcd(m,n);
		}
		
	}
}
