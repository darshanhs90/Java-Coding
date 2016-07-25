package eBayPrep;

import java.util.Arrays;

public class _059SpiralMatrix2 {


	public static void main(String[] args) {
		int[][] mat=generateMatrix(5);
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}

	public static int[][] generateMatrix(int n) {
		int outputMatrix[][]=new int[n][n];
		int value=1;
		int left=0,top=0,right=n-1,bottom=n-1;
		while(top<=bottom && left<=right)
		{
			for (int i = left; i <=right; i++) {
				outputMatrix[top][i]=value;
				value++;
			}
			top++;

			for (int i = top; i <=bottom; i++) {
				outputMatrix[i][right]=value;
				value++;
			}
			right--;

			if(top<=bottom){
				for (int i = right; i >=left; i--) {
					outputMatrix[bottom][i]=value;
					value++;
				}
				bottom--;
			}

			if(left<=right){
				for (int i = bottom; i >=top; i--) {
					outputMatrix[i][left]=value;
					value++;
				}
				left++;
			}
		}
		for (int i = 0; i < outputMatrix.length; i++) {
			System.out.println(Arrays.toString(outputMatrix[i]));
		}

		return outputMatrix;
	}
}

