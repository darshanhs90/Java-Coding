package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 */
public class _0098EditDistanceDP {
	public static void main(String[] args) {
		String x = "sunday";
		String y = "saturday";
		findEditDistance(x,y);
	}

	private static void findEditDistance(String x, String y) {
		int m=x.length();
		int n=y.length();
		int[][] dp=new int[m+1][n+1];
		for (int i = 0; i <=m; i++) {
			for (int j = 0; j <=n; j++) {
				if(i==0)
					dp[i][j]=j;
				else if(j==0)
					dp[i][j]=i;
				else if(x.charAt(i-1)==y.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else
					dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1]));
			}
		}

		System.out.println(dp[m][n]);


	}



}
