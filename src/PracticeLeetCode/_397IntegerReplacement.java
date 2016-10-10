package PracticeLeetCode;

public class _397IntegerReplacement {
	public static void main(String[] args) {
		System.out.println(integerReplacement(7));
	}
	public static int integerReplacement(int n) {
		return findMinMoves(0,n);
	}
	private static int findMinMoves(int count,int n) {
		if(n==1)
			return count;
		if(n%2==0)
			return findMinMoves(count+1, n/2);
		else
			return Math.min(findMinMoves(count+1, n+1), findMinMoves(count+1, n-1));
	}


}
