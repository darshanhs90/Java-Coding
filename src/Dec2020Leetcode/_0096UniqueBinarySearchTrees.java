package Dec2020Leetcode;

public class _0096UniqueBinarySearchTrees {

	public static void main(String[] args) {
		System.out.println(numTrees(1));
		System.out.println(numTrees(2));
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
		System.out.println(numTrees(5));
	}

	public static int numTrees(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;

		int[] numOfTrees = new int[n + 1];
		numOfTrees[0] = 1;
		numOfTrees[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				numOfTrees[i] += numOfTrees[j] * numOfTrees[i - j - 1];
			}
		}
		return numOfTrees[n];
	}

}
