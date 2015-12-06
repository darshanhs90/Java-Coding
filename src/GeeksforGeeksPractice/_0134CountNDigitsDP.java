package GeeksforGeeksPractice;

/*
 * Link: http://www.geeksforgeeks.org/count-of-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum/
 */
public class _0134CountNDigitsDP {
	public static void main(String[] args) {
		System.out.println(finalCount(2,5));
	}

	private static int finalCount(int n, int sum) {
		int ans=0;
		for (int i = 1; i <= 9; i++)
			if (sum-i >= 0)
				ans += countRec(n-1, sum-i);

		return ans;
	}

	private static int countRec(int n, int sum) {
		if (n == 0)
			return sum;

		int ans = 0;

		for (int i=0; i<=9; i++)
			if (sum-i >= 0)
				ans += countRec(n-1, sum-i);

		return ans;
	}

}
