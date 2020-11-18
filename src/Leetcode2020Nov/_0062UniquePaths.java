package Leetcode2020Nov;

public class _0062UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 7));
		System.out.println(uniquePaths(3, 2));
		System.out.println(uniquePaths(7, 3));
		System.out.println(uniquePaths(3, 3));
	}

	public static int uniquePaths(int m, int n) {
		return uniquePaths(0, 0, m, n);
	}

	public static int uniquePaths(int startX, int startY, int m, int n) {
		if (startX + 1 == m && startY + 1 == n)
			return 1;
		else if (startX > m || startY > n)
			return 0;
		return uniquePaths(startX, startY + 1, m, n) + uniquePaths(startX + 1, startY, m, n);
	}
}
