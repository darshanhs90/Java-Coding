package yelpInterview;

import java.util.Arrays;

public class _Matrix04MaximumSquareSubMatrix {
	public static void main(String a[]){
		int mat[][] = {{0, 1, 1, 0, 1}, 
				{1, 1, 0, 1, 0}, 
				{0, 1, 1, 1, 0},
				{1, 1, 1, 1, 0},
				{1, 1, 1, 1, 1},
				{0, 0, 0, 0, 0}};
		findMatSubMatrix(mat);
	}

	private static void findMatSubMatrix(int[][] mat) {
		int sum[][]=new int[mat.length][mat[0].length];
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum[0].length; j++) {
				if(i==0||j==0)
					sum[i][j]=mat[i][j];
				else
					if(mat[i][j]==1)
						sum[i][j]=Math.min(sum[i][j-1],Math.min(sum[i-1][j], sum[i-1][j-1]))+1;
					else
						sum[i][j]=0;
			}
		}
		printMatrix(sum);
		int maxVal=Integer.MIN_VALUE,xIndex=-1,yIndex=-1;
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum[0].length; j++) {
				if(sum[i][j]>maxVal){
					maxVal=sum[i][j];
					xIndex=i;
					yIndex=j;
				}
			}
		}
		for(int i = xIndex; i > xIndex - maxVal; i--)
		{
			for(int j = yIndex; j > yIndex - maxVal; j--)
			{
				System.out.print(mat[i][j]+" ");
			}  
			System.out.println();
		}  

	}

	private static void printMatrix(int[][] sum) {
		for (int i = 0; i < sum.length; i++) {
			System.out.println(Arrays.toString(sum[i]));
		}

	}


}