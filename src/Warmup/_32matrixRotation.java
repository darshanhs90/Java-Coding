package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _32matrixRotation {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String input=scanner.readLine();
		String inputArray[]=input.split(" ");
		int M=Integer.parseInt(inputArray[0]);
		int N=Integer.parseInt(inputArray[1]);
		int R=Integer.parseInt(inputArray[2]);
		int mainArray[][]=new int[M][N];
		int finalArray[][]=new int[M][N];
		for (int i = 0; i < M; i++) {
			String rowValue=scanner.readLine();
			String rowArray[]=rowValue.split(" ");
			for (int j = 0; j < N; j++) {
				mainArray[i][j]=Integer.parseInt(rowArray[j]);
			}
		}
		
		for (int i = 0; i < R/2; i++) {//number of outer regions
			
			
			
			
			
		}
	}
}
