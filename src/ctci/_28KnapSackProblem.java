package ctci;



/*Implementation of Knap Sack Problem*/
public class _28KnapSackProblem{

	public static void main(String[] args) {
		int val[] = {3,7,2,9};//{60, 100, 120};
		int wt[] = {2,3,4,5};//{10, 20, 30};
		int  W = 5;//50;
		System.out.println(performKnapSack(W,wt,val,val.length));
	}

	private static int performKnapSack(int W, int[] wt, int[] val, int n) {
		if(n==0||W==0)
			return 0;
		if (wt[n-1] > W)
			return performKnapSack(W, wt, val, n-1);
		else return Math.max( val[n-1] + performKnapSack(W-wt[n-1], wt, val, n-1),
				performKnapSack(W, wt, val, n-1)
				);
	}
}