package LeetCodePractice;

import java.util.Arrays;

public class _073SetMatrixZeroes {


	public static void main(String[] args) {
		setZeroesExtraSpace(new int[][]{{0,0,0,5},//0005
			{4,3,1,4},					//4314
			{0,1,1,4},					//0114
			{1,2,1,3},
			{0,0,1,1}});				//1213
	}									//0011


	public static void setZeroes(int[][] matrix) {
		boolean firstRowZero=false,firstColumnZero=false;
		//checkforfirst rowzero
		for (int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i]==0)
				firstRowZero=true;
		}
		//checkforfirst columnzero
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][0]==0)
				firstColumnZero=true;
		}

		//create the mark matrix 
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j]==0)
				{
					matrix[0][j]=0;
					matrix[i][0]=0;
				}
			}
		}
		printMatrix(matrix);
		System.out.println();
		//set depending on row
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][0]==0||matrix[0][j]==0)
				{
					matrix[i][j]=0;
				}
			}
		}

		if(firstRowZero)
		{
			//set first row to zero
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j]=0;
			}
		}
		if(firstColumnZero)
		{
			//set first row to zero
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][0]=0;
			}
		}
		printMatrix(matrix);


	}
	private static void printMatrix(int[][] matrix) {
		// TODO Auto-generated method stub
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}


	public static void setZeroesExtraSpace(int[][] matrix) {
		boolean rowMat[]=new boolean[matrix.length];
		boolean colMat[]=new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j]==0)
				{
					rowMat[i]=true;
					colMat[j]=true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(rowMat[i]||colMat[j])
				{
					matrix[i][j]=0;;
				}
			}
		}
		printMatrix(matrix);
	}

}

