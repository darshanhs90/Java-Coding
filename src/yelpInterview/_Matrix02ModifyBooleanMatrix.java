package yelpInterview;

import java.util.Arrays;

public class _Matrix02ModifyBooleanMatrix {
	public static void main(String a[]){
		int mat[][] = { {1, 0, 0, 1},
					    {0, 0, 1, 0},
					    {0, 0, 0, 0},
		};	
		modifyMatrix(mat);
	}

	private static void modifyMatrix(int[][] mat) {
		boolean rowFlag=false,colFlag=false;
		printMatrix(mat);
		for (int i = 0; i < mat[0].length; i++) {
			if(mat[0][i]==1){
				rowFlag=true;
				break;
			}
		}
		for (int i = 0; i < mat.length; i++) {
			if(mat[i][0]==1){
				colFlag=true;
				break;
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j]==1)
				{
					mat[0][j]=1;
					mat[i][0]=1;
				}
			}
		}
		printMatrix(mat);
		
		for (int i = mat.length-1; i >=1;i--) {
			for (int j =  mat[0].length-1;j>=1; j--) {
				if(mat[0][j]==1||mat[i][0]==1)
					mat[i][j]=1;
			}
		}
		printMatrix(mat);
		
		if(rowFlag)
		{
			Arrays.fill(mat[0], 1);
		}
		if(colFlag)
		{
			for (int j = 0; j < mat.length; j++) {
				mat[j][0]=1;
			}
		}
		printMatrix(mat);
	}

	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}System.out.println();

	}



}