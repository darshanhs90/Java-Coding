package hackerRank.CrackingTheCodingInterview;

import java.util.Arrays;
import java.util.Scanner;

public class _19CoinChange {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int coins[] = new int[m];
		for(int coins_i=0; coins_i < m; coins_i++){
			coins[coins_i] = in.nextInt();
		}
		System.out.println(findCoinsCount(coins,n));
	}

	private static int findCoinsCount(int[] coins, int n) {
		int dp[]=new int[n+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0]=0;
		for (int i = 0; i <=n; i++) {
			for (int j = 0; j < coins.length; j++) {
				if(i+coins[j]<=n)
				{
					if(dp[i]==Integer.MAX_VALUE)
					{
						dp[i+coins[j]]=dp[i+coins[j]];
					}else{
						dp[i+coins[j]]=Math.min(dp[i+coins[j]], dp[i]+1);
					}
				}
			}
		}

		if(dp[n]>=Integer.MAX_VALUE)
			return -1;
		return dp[n];
	}


}
