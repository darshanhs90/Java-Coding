package yelpInterview;

import java.util.Arrays;

public class _Matrix07CreateMatrixAlternateChars {
	public static void main(String a[]){
		int mat[][]=createMatrix(5,6);
		printMatrix(mat);
		System.out.println("*******");
		mat=createMatrix(4,4);
		printMatrix(mat);
		System.out.println("*******");
		mat=createMatrix(3,4);
		printMatrix(mat);
	}

	private static int[][] createMatrix(int rows, int cols) {
		int[][] mat=new int[rows][cols];
		int rowStart=0,rowEnd=rows,colStart=0,colEnd=cols;
		int value=1;
		while(rowStart<rowEnd && colStart<colEnd)
		{
			//start row
			for (int i = colStart; i < colEnd; i++) {
				mat[rowStart][i]=value;
			}
			rowStart++;

			//end column
			for (int i = rowStart; i < rowEnd; i++) {
				mat[i][colEnd-1]=value;
			}
			colEnd--;

			//end row
			if(rowStart<rowEnd)
			{
				for (int i = colEnd-1; i>=colStart; i--) {
					mat[rowEnd-1][i]=value;
				}
				rowEnd--;
			}

			//start column
			if(colStart<colEnd)
			{
				for (int i = rowEnd-1; i>=rowStart; i--) {
					mat[i][colStart]=value;
				}
				colStart++;
			}
			value=value==1?0:1;
		}
		return mat;
	}

	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}



}