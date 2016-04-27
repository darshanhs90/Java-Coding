package yelpInterview;

import java.util.Arrays;

public class _Matrix16CollectMaxPointsUsingTraversals {

	public static void main(String a[]){
		int mat[][]={{3, 6, 8, 2},
				{5, 2, 4, 3},
				{1, 1, 20, 10},
				{1, 1, 20, 10},
				{1, 1, 20, 10},
		};
		printMatrix(mat);
		System.out.println(collectMaxPoints(mat));

	}
	static boolean visited[][];


	private static int collectMaxPoints(int[][] mat) {
		visited=new boolean[mat.length][mat[0].length];
		int startScore=maxStartPoints(mat,0,0);
		System.out.println(startScore);
		visited=new boolean[mat.length][mat[0].length];
		int endScore=maxEndPoints(mat,0,mat[0].length-1);
		System.out.println(endScore);
		return startScore+endScore;
	}

	private static int maxStartPoints(int[][] mat, int i, int j) {
		if(i<0||i>mat.length-1||j<0||j>mat[0].length-1||visited[i][j])
			return 0;
		if(i==mat.length-1 && j==0)
			return mat[i][j];
		visited[i][j]=true;
		return mat[i][j]+Math.max(maxStartPoints(mat, i+1, j), Math.max(maxStartPoints(mat, i+1, j-1),maxStartPoints(mat, i+1, j+1)));
	}

	private static int maxEndPoints(int[][] mat, int i, int j) {
		if(i<0||i>mat.length-1||j<0||j>mat[0].length-1||visited[i][j])
			return 0;
		if(i==mat.length-1 && j==mat[0].length-1)
			return mat[i][j];
		visited[i][j]=true;
		return mat[i][j]+Math.max(maxEndPoints(mat, i+1, j), Math.max(maxEndPoints(mat, i+1, j-1),maxEndPoints(mat, i+1, j+1)));
	}


	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}	
		System.out.println();
	}





}