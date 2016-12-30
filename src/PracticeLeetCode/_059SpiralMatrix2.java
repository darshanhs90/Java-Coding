package PracticeLeetCode;

import java.util.Arrays;

public class _059SpiralMatrix2 {
	public static void main(String[] args) {
		int[][] arr=generateMatrix(3);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	public static int[][] generateMatrix(int n) {
		int[][] matrix=new int[n][n];
		if(n==0)
			return matrix;
		int count=1;
		int top=0,left=0,right=matrix[0].length-1,bottom=matrix.length-1;
		while(top<=bottom && left<=right)
		{
			//toprow
			for (int i = left; i <=right; i++) {
				matrix[top][i]=count;
				count++;
			}
			top++;



			//right col
			for (int i = top; i <=bottom; i++) {
				matrix[i][right]=count;
				count++;
			}
			right--;
			//bottom row
			if(top>bottom){
				continue;
			}
			for (int i = right; i >=left; i--) {
				matrix[bottom][i]=count;
				count++;
			}
			bottom--;

			//left col
			if(left>right){
				continue;
			}
			for (int i = bottom; i >=top; i--) {
				matrix[i][left]=count;
				count++;
			}
			left++;
		}
		return matrix;
	}
}

