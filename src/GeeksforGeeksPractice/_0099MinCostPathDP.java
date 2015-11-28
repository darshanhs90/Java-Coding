package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
public class _0099MinCostPathDP {
	public static void main(String[] args) {
		int cost[][] = { {1, 2, 3},
				{4, 8, 2},
				{1, 5, 3} };
		System.out.println(minCost(cost,cost.length-1,cost[0].length-1));
		System.out.println(minCostDP(cost,cost.length-1,cost[0].length-1));
	}

	private static int minCostDP(int[][] cost,int m,int n) {
		int[][] costNew=new int[m+1][n+1];
		costNew[0][0]=cost[0][0];
		for (int i = 1; i <=m; i++) {
			costNew[i][0]=costNew[i-1][0]+cost[i][0];
		}
		for (int i = 1; i <=n; i++) {
			costNew[0][i]=costNew[0][i-1]+cost[0][i];
		}
		
		for (int i = 1; i <=m; i++) {
			for (int j = 1; j <=n; j++) {
				costNew[i][j]=Math.min(costNew[i][j-1],Math.min(costNew[i-1][j], costNew[i-1][j-1]))+cost[i][j];
			}
		}
		return costNew[m][n];
	}

	private static int minCost(int[][] cost,int m,int n) {	
		
		if(n<0||m<0)
			return Integer.MAX_VALUE;
		else if(m==0 && n==0)
			return cost[m][n];
		else
			return cost[m][n]+Math.min(minCost(cost,m-1,n),Math.min(minCost(cost, m, n-1),minCost(cost, m-1, n-1)));
	}



}
