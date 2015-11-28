package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/count-number-islands-every-island-separated-line/
 */
public class _0088CountNumberOfIslands {

	public static void main(String[] args) {
		char mat[][] =  {{'O', 'O', 'O'},
				{'X', 'X', 'O'},
				{'X', 'X', 'O'},
				{'O', 'O', 'X'},
				{'O', 'O', 'X'},
				{'X', 'X', 'O'}
		};
		printMatrix(mat);
		System.out.println();
		System.out.println(countNoOfIslands(mat));
	}



	private static int countNoOfIslands(char[][] mat) {
		int count=0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j]=='X')
					if((i==0||mat[i-1][j]=='O')&& (j==0||mat[i][j-1]=='O'))
						count++;
			}
		}
		return count;
	}



	private static void printMatrix(char[][] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println(Arrays.toString(s[i]));
		}

	}


}
