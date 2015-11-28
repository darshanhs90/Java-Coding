package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 */
public class _0097LongestCommonSubsequenceDP {
	public static void main(String[] args) {
		String x= "AGGTAB";
		String y = "GXTXAYB";

		findLCS(x,y);
	}

	private static void findLCS(String x, String y) {
		int[][] LCS=new int[x.length()+1][y.length()+1];
		for (int i = 0; i <= x.length(); i++) {
			for (int j = 0; j <= y.length(); j++) {
				if(i==0||j==0)
					LCS[i][j]=0;
				else if(x.charAt(i-1)==y.charAt(j-1))
					LCS[i][j]=LCS[i-1][j-1]+1;
				else
					LCS[i][j]=Math.max(LCS[i-1][j],LCS[i][j-1]);
			}
		}
		System.out.println(LCS[x.length()][y.length()]);
	}




}
