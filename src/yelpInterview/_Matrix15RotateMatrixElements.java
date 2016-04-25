package yelpInterview;

import java.util.Arrays;

public class _Matrix15RotateMatrixElements {

	public static void main(String a[]){
		int mat[][]={ 
				{1,  2,  3,  4},
				{5,  6,  7,  8},
				{9,  10, 11, 12},
				{13, 14, 15, 16} 
		};
		printMatrix(mat);
		mat=rotateMatrix(mat);
		printMatrix(mat);
		mat=new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		printMatrix(mat);
		mat=rotateMatrix(mat);
		printMatrix(mat);
	}

	private static int[][] rotateMatrix(int[][] mat) {
		int row=0,col=0,rowEnd=mat.length,colEnd=mat[0].length;

		while(row<rowEnd && col<colEnd)
		{	
			if (row + 1 == rowEnd || col + 1 == colEnd)
				break;
			int prev=mat[row+1][col];
			//first row
			int curr=0;
			for (int i = col; i < colEnd; i++) {
				curr=mat[row][i];
				mat[row][i]=prev;
				prev=curr;
			}
			row++;
			//last col
			for (int i = row; i < rowEnd; i++) {
				curr=mat[i][colEnd-1];
				mat[i][colEnd-1]=prev;
				prev=curr;
			}
			colEnd--;

			//last row
			if(row<rowEnd){
				for (int i = colEnd-1; i >=col; i--) {
					curr=mat[rowEnd-1][i];
					mat[rowEnd-1][i]=prev;
					prev=curr;
				}
				rowEnd--;
			}
			//first col
			if(col<colEnd){
				for (int i = rowEnd-1; i >=row; i--) {
					curr=mat[i][col];
					mat[i][col]=prev;
					prev=curr;
				}
				col++;
			}

		}





		return mat;
	}

	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}	
		System.out.println();
	}





}