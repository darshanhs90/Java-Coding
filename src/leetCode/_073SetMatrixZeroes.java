package leetCode;

import java.util.Arrays;

/*
 * Link : https://leetcode.com/problems/climbing-stairs/
 */

public class _073SetMatrixZeroes {
	public static void setZeroes(int[][] matrix) {
		int rows=matrix.length;
		int cols=matrix[0].length;
		boolean rowsCheck[]=new boolean[rows];
		boolean colsCheck[]=new boolean[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(matrix[i][j]==0)
				{
					rowsCheck[i]=true;
					colsCheck[j]=true;
				}
			}
		}
		System.out.println(Arrays.toString(rowsCheck));
		System.out.println(Arrays.toString(colsCheck));
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(colsCheck[j]==true||rowsCheck[i]==true)
					matrix[i][j]=0;
			}
		}
	}
	public static void main(String[] args) {
		int matrix[][]=new int[][]{
			{1,2,3,4,5},
			{0,2,2,2,2},
			{3,2,2,2,0},
			{4,3,4,3,4}
		};
		setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+"/");
			}
			System.out.println();
		}
	}
}