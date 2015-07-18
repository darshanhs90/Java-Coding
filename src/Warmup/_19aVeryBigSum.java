package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _19aVeryBigSum {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		long N=Integer.parseInt(scanner.readLine());
		Long sum=0l;
		String lineArray=scanner.readLine();
		String[] lineSplit=lineArray.split(" ");
		for (int i = 0; i < N; i++) {
			sum+=Long.parseLong(lineSplit[i]);
		}
		System.out.println(sum);
	}
}
