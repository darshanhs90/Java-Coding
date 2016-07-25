package eBayPrep;

import java.util.Arrays;

public class _073SetMatrixZeroes {


	public static void main(String[] args) {
		setZeroes(new int[][]{	{1,2,3,4},//0005
								{5,0,5,2},//4314
								{8,9,2,0},//0114
								{5,7,2,1}});//0011				
	}									


	public static void setZeroes(int[][] matrix) {
		boolean fillFirstRow=false,fillFirstCol=false;
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][0]==0)
				fillFirstCol=true;
		}
		for (int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i]==0)
				fillFirstRow=true;
		}
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j]==0)
				{
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][0]==0 || matrix[0][j]==0)
				{
					matrix[i][j]=0;
				}
			}
		}
		if(fillFirstRow)
		{
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i]=0;
			}
		}
		if(fillFirstCol)
		{
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0]=0;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

}

