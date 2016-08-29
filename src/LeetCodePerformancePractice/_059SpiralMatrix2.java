package LeetCodePerformancePractice;

import java.util.Arrays;

public class _059SpiralMatrix2 {
	public static void main(String[] args) {
		int[][] arr=generateMatrix(3);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	public static int[][] generateMatrix(int n) {
		int[][] arr=new int[n][n];
		int top=0,left=0,right=n-1,bottom=n-1;
		int count=1;
		while(count<=n*n)
		{
			//top row
			for (int i = left; i <=right; i++) {
				arr[top][i]=count;
				count++;
			}
			top++;
			//right col
			for (int i = top; i <=bottom; i++) {
				arr[i][right]=count;
				count++;
			}
			right--;

			//bottom row
			if(bottom<top)
				break;
			for (int i = right; i >=left; i--) {
				arr[bottom][i]=count;
				count++;
			}
			bottom--;


			//left col
			if(right<left)
				break;
			for (int i = bottom; i >=top; i--) {
				arr[i][left]=count;
				count++;
			}
			left++;

		}
		return arr;
	}
}

