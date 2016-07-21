package LeetCodePractice;

import java.util.Arrays;

public class _048RotateImage {

	public static void main(String[] args) {
		rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
	}
	/*public static void rotate(int[][] matrix) {
		int top=0,left=0,right=matrix.length-1,bottom=matrix[0].length-1;
		while(left<right && top<bottom)
		{
			//go over first row
			int temp=matrix[left][top+1];
			for (int i = left; i <=right; i++) {
				int newTemp=matrix[top][i];
				matrix[top][i]=temp;
				temp=newTemp;
			}
			top++;


			//right column
			for (int i = top; i <=bottom; i++) {
				int newTemp=matrix[right][i];
				matrix[right][i]=temp;
				temp=newTemp;
			}
			right--;


			//bottom row
			for (int i = right; i >=left; i--) {
				int newTemp=matrix[bottom][i];
				matrix[bottom][i]=temp;
				temp=newTemp;
			}
			bottom--;


			//left column
			for (int i = bottom; i >=top; i--) {
				int newTemp=matrix[i][left];
				matrix[i][left]=temp;
				temp=newTemp;
			}
			left++;
			matrix[left-1][top-1]=temp;

		}

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

	}*/



	public static void rotate(int[][] matrix) {
		int n=matrix.length;
		for (int i = 0; i < matrix.length/2; i++) {//row
			for (int j = 0; j < Math.ceil(((double) n) / 2); j++) {//col
				int temp=matrix[i][j];
				matrix[i][j]=matrix[n-1-j][i];
				matrix[n-1-j][j]=matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
				matrix[j][n-1-i]=temp;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}


	}
}

