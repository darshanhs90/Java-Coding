package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16sherlockAndTheBeast {
	public static void main(String[] args) throws IOException {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		long T=Long.parseLong(scanner.readLine());
		for (long noOfTestCases = 0; noOfTestCases < T; noOfTestCases++) {
			long N=Long.parseLong(scanner.readLine());
			long noOfFives=N;
			long noOfThrees=0;
			boolean num=false;
			while(true)
			{
				if(noOfFives%3==0 && noOfThrees%5==0)
				{	
					num=true;
					break;
				}
				else
				{
					noOfFives--;
					noOfThrees++;
				}
				if(noOfFives<0)
					break;
			}
			if(num==true){
				StringBuilder sb=new StringBuilder();
				for (int i = 0; i < noOfFives; i++) {
					sb.append('5');
				}
				for (int i = 0; i < noOfThrees; i++) {
					sb.append('3');
				}
				System.out.println(sb.toString());
			}
			else
				System.out.println("-1");
		}
	}
}
