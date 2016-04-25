package yelpInterview;

import java.util.Arrays;

public class _Matrix13FindSumOfElements {

	public static void main(String a[]){
		int[][] mat=new int[][]{
			{1, 1, 2},
			{3, 4, 6},
			{5, 3, 2} 
		};
		System.out.println(findSum(mat,0,0));
		System.out.println(findSum(mat,1,1));
		System.out.println(findSum(mat,0,1));
	}

	private static int findSum(int[][] mat, int x, int y) {
		int rowMat[]=new int[mat.length];
		int colMat[]=new int[mat[0].length];
		int sum=0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				sum+=mat[i][j];
				rowMat[i]+=mat[i][j];
				colMat[j]+=mat[i][j];
			}
		}
		return sum-rowMat[x]-colMat[y]+mat[x][y];
	}

	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}	
		System.out.println();
	}





}