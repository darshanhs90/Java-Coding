package appleInterview;

import java.util.Arrays;

public class _16PrepDocFibonacciSeries {
	public static void main(String[] args) {
		printFiboNacciSeries(10);
		printFiboNacciSeries(7);
	}

	private static void printFiboNacciSeries(int i) {
		if(i==0)return;
		if(i==1){System.out.println(1);return;}
		if(i==2){System.out.println(1+"/"+1);return;}
		int fibo[]=new int[i];
		fibo[0]=1;
		fibo[1]=1;
		for (int j = 2; j < i; j++) {
			fibo[j]=fibo[j-1]+fibo[j-2];
		}
		System.out.println(Arrays.toString(fibo));
	}


}
