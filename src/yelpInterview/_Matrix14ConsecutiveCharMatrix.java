package yelpInterview;

import java.util.Arrays;

public class _Matrix14ConsecutiveCharMatrix {

	public static void main(String a[]){
		char[][] mat=new char[][]{ 
			{'a', 'c', 'd'},
			{'h', 'b', 'e'},
			{'i', 'g', 'f'}
		};
		printMatrix(mat);
		System.out.println(findLongestIncreasing(mat,'e'));
		mat=new char[][]{ 
			{'b','e', 'f'},
			{'h', 'd', 'a'},
			{'i', 'c', 'a'}
		};
		printMatrix(mat);
		System.out.println(findLongestIncreasing(mat,'b'));
	}
	static boolean[][] visited;
	private static int findLongestIncreasing(char[][] mat,char start) {
		int count=0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(mat[i][j]!=start)
					continue;
				visited=new boolean[mat.length][mat[0].length];
				int val=getMaxCount(mat,i,j,visited);
				count=Math.max(count, val);
			}
		}
		return count+1;
	}

	private static int getMaxCount(char[][] mat, int i, int j, boolean[][] visited) {
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
		else if(i-1>=0 && j-1>=0  && mat[i-1][j-1]==mat[i][j]+1){
			visited[i][j]=true;
			return 1+getMaxCount(mat, i-1, j-1, visited);
		}else if(i-1>=0 && j+1<mat[0].length && mat[i-1][j+1]==mat[i][j]+1){
			visited[i][j]=true;
			return 1+getMaxCount(mat, i-1, j+1, visited);
		}else if(j-1>=0 && i+1<mat.length && mat[i+1][j-1]==mat[i][j]+1){
			visited[i][j]=true;
			return 1+getMaxCount(mat, i+1, j-1, visited);
		}else if(i+1<mat.length && j+1<mat[0].length && mat[i+1][j+1]==mat[i][j]+1){
			visited[i][j]=true;
			return 1+getMaxCount(mat, i+1, j+1, visited);
		}
		return 0;
	}

	private static void printMatrix(char[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}	
	}





}