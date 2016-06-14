package LeetCodePractice;

public class _062UniquePaths {


	public static void main(String[] args) {
		System.out.println(uniquePaths(23, 12));
	}

	public static int uniquePaths(int m, int n) {
		int value=(dfs(0,0,m,n));
		return value;
	}

	private static int dfs(int i,int j,int m, int n) {
		if(i==m-1 && j==n-1)
			return 1;
		if(i<0 || j<0 ||i>m-1||j>n-1)
			return 0;
		return dfs(i+1, j, m, n)+dfs(i, j+1, m, n);
		
	}

}

