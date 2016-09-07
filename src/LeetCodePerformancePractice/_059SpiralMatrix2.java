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
		int[][] outputMatrix=new int[n][n];
		int top=0,left=0,right=n-1,bottom=n-1;
		int count=1;
		while(top<=bottom && left<=right)
		{
			for (int i = left; i <=right; i++) {
				outputMatrix[top][i]=count;
				count++;
			}
			top++;
			for (int i = top; i <=bottom; i++) {
				outputMatrix[i][right]=count;
				count++;
			}
			right--;
			if(top>bottom)
				continue;
			for (int i = right; i >=left; i--) {
				outputMatrix[bottom][i]=count;
				count++;
			}
			bottom--;
			if(left>right)
				continue;
			for (int i = bottom; i >=top; i--) {
				outputMatrix[i][left]=count;
				count++;
			}	
			left++;
		}
		return outputMatrix;
	}
}

