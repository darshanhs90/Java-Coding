package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0060PermutationSequence {
	// https://www.youtube.com/watch?v=W9SIlE2jhBQ
	public static void main(String[] args) {
		System.out.println(getPermutation(3, 3));
		System.out.println(getPermutation(4, 9));
		System.out.println(getPermutation(3, 1));
	}

	public static String getPermutation(int n, int k) {
		int factorial[] = new int[n + 1];
		factorial[0] = 1;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for (int i = 1; i < n; i++) {
			factorial[i] = factorial[i - 1] * i;
			list.add(i + 1);
		}
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			int index = k / factorial[n - 1];

			if (k % factorial[n - 1] == 0)
				index--;

			sb.append(list.get(index));
			list.remove(index);

			int blockSize = factorial[n - 1];

			k = k - blockSize * index;
			n--;
		}
		return sb.toString();
	}
}
