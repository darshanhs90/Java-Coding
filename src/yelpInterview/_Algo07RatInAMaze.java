package yelpInterview;

import java.util.Arrays;

public class _Algo07RatInAMaze {

	public static void main(String a[]){
		int[][] matrix=new int[][]{{1, 0, 0, 0},
			{1, 1, 0, 1},
			{0, 1, 0, 0},
			{1, 1, 1, 1}};
			System.out.println(isPathPresent(matrix));
			for (int i = 0; i < matrix.length; i++) {
				System.out.println(Arrays.toString(visited[i]));
			}
	}
	static boolean visited[][];
	private static boolean isPathPresent(int[][] matrix) {
		visited=new boolean[matrix.length][matrix[0].length];
		return isPathPresentUtil(matrix,0,0);
	}
	private static boolean isPathPresentUtil(int[][] matrix, int i, int j) {
		if(i<0||i>matrix.length-1||j<0||j>matrix[0].length||visited[i][j]||matrix[i][j]==0)
			return false;
		if(i==matrix.length-1 && j==matrix[0].length-1){
			visited[i][j]=true;
			return true;
		}
		visited[i][j]=true;
		return isPathPresentUtil(matrix, i+1, j)|| isPathPresentUtil(matrix, i, j+1);
	}



}

