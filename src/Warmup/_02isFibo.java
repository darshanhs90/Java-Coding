package Warmup;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Problem Statement Link:https://www.hackerrank.com/challenges/is-fibo
 */

public class _02isFibo {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Long noOfTestCases=Long.parseLong(br.readLine());
		//System.out.println(noOfTestCases);
		Long a=0l;
		ArrayList<Long> arrayList=new ArrayList<Long>();
		Long fib0=0l;//0,1,1,2,3,5,8
		Long fib1=1l;
		arrayList.add(fib0);
		arrayList.add(fib1);
		while(fib1<=10000000000l &&fib1>0)
		{	
			//System.out.println(fib1);
			arrayList.add(fib1);
			Long fib=fib0;
			fib0=fib1;
			try{
				fib1=fib1+fib;
			}
			catch(NumberFormatException e){

			}
		}
		for (long i = 0; i < noOfTestCases; i++) {
			try{
				a=Long.parseLong(br.readLine());

				if(a>10000000000l){
					System.out.println("IsNotFibo");	
				}
				else{
					if(arrayList.indexOf(a)!=-1){
						System.out.println("IsFibo");
					}
					else{
						System.out.println("IsNotFibo");
					}

				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("IsNotFibo");
			}
		}
	}
}
