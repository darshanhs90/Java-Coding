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
		int[][] output=new int[n][n];
		int top=0,bottom=n-1,left=0,right=n-1;
		int count=1;
		while(top<=bottom && left<=right)
		{
			//toprow
			for (int i = left; i <=right; i++) {
				output[top][i]=count;
				count++;
			}
			top++;

			//right col
			for (int i = top; i <=bottom; i++) {
				output[i][right]=count;
				count++;
			}
			right--;

			//bottom row
			if(top>bottom)
				continue;
			for (int i = right; i >=left; i--) {
				output[bottom][i]=count;
				count++;
			}
			bottom--;

			//left col
			if(left>right)
				continue;
			for (int i = bottom; i>=top; i--) {
				output[i][left]=count;
				count++;
			}
			left++;
		}
		return output;
	}
}

