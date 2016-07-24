package eBayPrep;

import java.util.Arrays;

public class _048RotateImage {

	public static void main(String[] args) {
		rotate(new int[][]{{1,2,3},
							{4,5,6},
							{7,8,9}});
	}

	public static void rotate(int[][] arr) {
		int n=arr.length;
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < Math.ceil((double)n/2); j++) {
				int temp=arr[i][j];
				arr[i][j]=arr[n-1-j][i];
				arr[n-1-j][i]=arr[n-1-i][n-1-j];
				arr[n-1-i][n-1-j]=arr[j][n-1-i];
				arr[j][n-1-i]=temp;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}
	
}

