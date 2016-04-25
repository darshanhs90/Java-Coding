package yelpInterview;

import java.util.Arrays;

public class _Matrix11ReplaceXO {
	static char[][] mat;
	public static void main(String a[]){
		mat=new char[][]{{'X', 'O', 'X', 'X', 'X', 'X'},
			{'X', 'O', 'X', 'X', 'O', 'X'},
			{'X', 'X', 'X', 'O', 'O', 'X'},
			{'O', 'X', 'X', 'X', 'X', 'X'},
			{'X', 'X', 'X', 'O', 'X', 'O'},
			{'O', 'O', 'X', 'O', 'O', 'O'},
		};
		printMatrix(mat);
		mat=(replaceMatrix(mat));
		printMatrix(mat);
	}

	private static char[][] replaceMatrix(char[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(mat[i][j]=='O')
					mat[i][j]='-';
			}
		}


		//first row
		for (int i = 0; i < mat[0].length; i++) {
			if(mat[0][i]=='-')
				floodUtil(0,i,'-','O');
		}

		//first column
		for (int i = 0; i < mat.length; i++) {
			if(mat[i][0]=='-')
				floodUtil(i,0,'-','O');
		}

		//last row
		for (int i = 0; i < mat[0].length; i++) {
			if(mat[mat.length-1][i]=='-')
				floodUtil(mat.length-1,i,'-','O');
		}

		//last column
		for (int i = 0; i < mat.length; i++) {
			if(mat[i][mat[0].length-1]=='-')
				floodUtil(i,mat[0].length-1,'-','O');
		}

		for (int i=0; i<mat.length; i++)
			for (int j=0; j<mat[0].length; j++)
				if (mat[i][j] == '-')
					mat[i][j] = 'X';
		return mat;
	}

	private static void floodUtil(int x, int y, char prevV, char newV) {
		if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length)
			return;
		if (mat[x][y] != prevV)
			return;

		mat[x][y] = newV;

		floodUtil(x+1, y, prevV, newV);
		floodUtil(x-1, y, prevV, newV);
		floodUtil(x, y+1, prevV, newV);
		floodUtil(x, y-1, prevV, newV);

	}

	private static void printMatrix(char[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}	
		System.out.println();
	}





}