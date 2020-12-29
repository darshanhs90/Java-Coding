package LeetcodeTemplate;

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
		
		return sb.toString();
	}
}
