package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class serviceLane {
	public static void main(String[] args) throws IOException {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String firstLine=scanner.readLine();
		String flArray[]=firstLine.split(" ");
		int N=Integer.parseInt(flArray[0]);
		int T=Integer.parseInt(flArray[1]);
		String []widthArray=scanner.readLine().split(" ");
		for (int testCaseNum = 0; testCaseNum < T; testCaseNum++) {
			String str[]=scanner.readLine().split(" ");
			int i=Integer.parseInt(str[0]);
			int j=Integer.parseInt(str[1]);
			int min=3;
			for (int j2 = i; j2 < j; j2++) {
				if(min>Integer.parseInt(widthArray[j2]))
						min=Integer.parseInt(widthArray[j2]);
			}
			System.out.println(min);
		}
	}
}
