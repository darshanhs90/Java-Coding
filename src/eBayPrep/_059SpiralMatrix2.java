package LeetCodePractice;

import java.util.Arrays;

public class _059SpiralMatrix2 {


	public static void main(String[] args) {
		int[][] mat=generateMatrix(3);
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}

	public static int[][] generateMatrix(int n) {
		int value=1;
		int [][]outputMatrix=new int[n][n];
		int left=0,right=n-1,top=0,bottom=n-1;
		while(left<=right && top<=bottom)
		{
			//toprrow
			for (int i = left; i <=right; i++) {
				outputMatrix[top][i]=value;
				value++;
			}
			top++;

			//rightcol
			for (int i = top; i <=bottom; i++) {
				outputMatrix[i][right]=value;
				value++;
			}
			right--;

			//bottomrow
			if(left<right){
				for (int i = right; i >=left; i--) {
					outputMatrix[bottom][i]=value;
					value++;
				}
				bottom--;
			}

			//leftcol
			if(top<bottom){
				for (int i = bottom; i >=top; i--) {
					outputMatrix[i][left]=value;
					value++;
				}
				left++;
			}
		}

		return outputMatrix;
	}
}

