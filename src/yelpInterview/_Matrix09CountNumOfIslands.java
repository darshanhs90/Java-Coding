package yelpInterview;

public class _Matrix09CountNumOfIslands {
	public static void main(String a[]){
		char mat[][]={{'O', 'O', 'O'},
				{'X', 'X', 'O'},
				{'X', 'X', 'O'},
				{'O', 'O', 'X'},
				{'O', 'O', 'X'},
				{'X', 'X', 'O'}
		};
		System.out.println(countIslands(mat));
		mat= new char[][]{{'X', 'O', 'O', 'O', 'O', 'O'},
			{'X', 'O', 'X', 'X', 'X', 'X'},
			{'O', 'O', 'O', 'O', 'O', 'O'},
			{'X', 'X', 'X', 'O', 'X', 'X'},
			{'X', 'X', 'X', 'O', 'X', 'X'},
			{'O', 'O', 'O', 'O', 'X', 'X'},
		};
		System.out.println(countIslands(mat));
	}
	static boolean visited[][];
	private static int countIslands(char[][] mat) {
		visited=new boolean[mat.length][mat[0].length];
		int count=0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(!visited[i][j])
					count+=hasIsland(mat,i,j)>0?1:0;;
			}
		}
		return count;
	}
	private static int hasIsland(char[][] mat, int i, int j) {
		if(i<0||i>=mat.length||j<0||j>=mat[0].length)
			return 0;
		if(visited[i][j])
			return 0;
		visited[i][j]=true;
		if(mat[i][j]=='X')
			return 1+hasIsland(mat, i+1, j)+hasIsland(mat, i-1, j)
			+hasIsland(mat, i, j-1)+hasIsland(mat, i, j+1);
		return 0;
	}




}