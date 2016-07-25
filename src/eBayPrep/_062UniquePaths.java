package eBayPrep;

public class _062UniquePaths {


	public static void main(String[] args) {
		System.out.println(uniquePaths(23, 12));
	}

	public static int uniquePaths(int m, int n) {
		return dfs(0,0,m,n);
	}

	private static int dfs(int i, int j, int m, int n) {
		if(i<0||j<0||i>=m||j>=n)
			return 0;
		if(i==m-1 && j==n-1)
			return 1;
		return dfs(i+1,j,m,n)+dfs(i,j+1,m,n);
	}
}

