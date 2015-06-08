package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class _11manasaAndStones {
	public static void main(String[] args) throws IOException {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(scanner.readLine());
		for (int noOfTestCases = 0; noOfTestCases < T; noOfTestCases++) {
			int n=Integer.parseInt(scanner.readLine());
			int a=Integer.parseInt(scanner.readLine());
			int b=Integer.parseInt(scanner.readLine());
			int count1=n-1,count2=0;
			TreeSet<Integer> t=new TreeSet<Integer>();
			while(count1>=0)
			{
				int val=count1*a+count2*b;
				count1--;
				count2++;
				t.add(val);
			}
			Object[] array=t.toArray();
			Arrays.sort(array);
			for (int i = 0; i < array.length; i++) {
				if(i!=array.length-1)
					System.out.print(array[i]+" ");
				else
					System.out.print(array[i]);
			}
			System.out.println();
		}
	}
}
