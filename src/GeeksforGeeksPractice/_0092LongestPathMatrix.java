package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
 */
public class _0092LongestPathMatrix {
	public static void main(String[] args) {
		int mat[][] = {{1, 2, 9},
				{5, 3, 8},
				{4, 6, 7}};
		System.out.println(findLongestPath(mat));
		
	}


	private static int findLongestPath(int[][] mat) {
		int result=-1;
		printMatrix(mat);
		int dp[][]=new int[mat.length][mat[0].length];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i],-1);
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if(dp[i][j]==-1)
					findLongestCell(i,j,mat,dp);		
				result=Math.max(result,dp[i][j]);
			}
		}
		return result;
	}








	private static int findLongestCell(int i, int j, int[][] mat, int[][] dp) {
		int rows=mat.length,cols=mat[0].length;
		if(i<0||i>=rows||j<0||j>=cols)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		
		if((mat[i][j]+1)==mat[i][j+1])
			return dp[i][j]=1+findLongestCell(i, j+1, mat, dp);
		
		if(mat[i][j]==(mat[i][j-1]+1))
			return dp[i][j]=1+findLongestCell(i, j-1, mat, dp);
		if(mat[i][j]==(mat[i-1][j]+1))
			return dp[i][j]=1+findLongestCell(i-1, j, mat, dp);
		
		if((mat[i][j]+1)==mat[i+1][j])
			return dp[i][j]=1+findLongestCell(i+1, j, mat, dp);

		

		

		return dp[i][j]=1;
		
	}


	private static void printMatrix(int[][] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println(Arrays.toString(s[i]));
		}

	}


}
