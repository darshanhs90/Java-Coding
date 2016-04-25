package yelpInterview;

import java.util.Arrays;

public class _Matrix12LongestPathMatrix {

	public static void main(String a[]){
		int[][] mat=new int[][]{{1, 2, 9},
			{5, 3, 8},
			{4, 6, 7}};
			printMatrix(mat);
			System.out.println(findLongestIncreasing(mat));
			mat=new int[][]{{1, 2, 3},
				{6, 5, 4},
				{7, 8, 9}
			};
			printMatrix(mat);
			System.out.println(findLongestIncreasing(mat));
	}
	static boolean[][] visited;
	private static int findLongestIncreasing(int[][] mat) {
		int count=0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				visited=new boolean[mat.length][mat[0].length];
				int val=getMaxCount(mat,i,j,visited);
				count=Math.max(count, val);
			}
		}
		return count+1;
	}

	private static int getMaxCount(int[][] mat, int i, int j, boolean[][] visited) {
		if(i<0||i>=mat.length||j<0||j>=mat[0].length||visited[i][j])
			return 0;
		if(i-1>=0 && mat[i-1][j]==mat[i][j]+1){
			visited[i][j]=true;
			return 1+getMaxCount(mat, i-1, j, visited);
		}else if(i+1<mat.length && mat[i+1][j]==mat[i][j]+1){
			visited[i][j]=true;
			return 1+getMaxCount(mat, i+1, j, visited);
		}else if(j-1>=0 && mat[i][j-1]==mat[i][j]+1){
			visited[i][j]=true;
			return 1+getMaxCount(mat, i, j-1, visited);
		}else if(j+1<mat[0].length && mat[i][j+1]==mat[i][j]+1){
			visited[i][j]=true;
			return 1+getMaxCount(mat, i, j+1, visited);
		}
		return 0;
	}

	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}	
	}





}