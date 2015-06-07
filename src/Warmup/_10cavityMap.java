package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10cavityMap {
	public static void main(String[] args) throws IOException {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(scanner.readLine());
		int[][] matrix=new int[N][N];
		for (int noOfLines = 0; noOfLines < N; noOfLines++) {
			String str[]=scanner.readLine().split("");	
			for (int i = 1; i <str.length; i++) {
				matrix[noOfLines][i-1]=Integer.parseInt(str[i]);
			}
		}
		for (int rowNum = 0; rowNum < matrix.length; rowNum++) {
			for (int colNum = 0; colNum < matrix.length; colNum++) {
				//if border condition print it out
				if(rowNum==0||rowNum==matrix.length-1||colNum==0||colNum==matrix.length-1)
					System.out.print(matrix[rowNum][colNum]);
				else{
					if(matrix[rowNum][colNum]<=matrix[rowNum-1][colNum])//top condition fail
					{
						System.out.print(matrix[rowNum][colNum]);
					}
					else if(matrix[rowNum][colNum]<=matrix[rowNum+1][colNum])//bottom condition fail
					{
						System.out.print(matrix[rowNum][colNum]);
					}
					else if(matrix[rowNum][colNum]<=matrix[rowNum][colNum-1])//left condition fail
					{
						System.out.print(matrix[rowNum][colNum]);
					}
					else if(matrix[rowNum][colNum]<=matrix[rowNum][colNum+1])//right condition fail
					{
						System.out.print(matrix[rowNum][colNum]);
					}
					else
						System.out.print("X");
				}
					
			}
			System.out.println();
		}
	}	
}
