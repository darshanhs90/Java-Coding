package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.List;

public class _0989AddToArrayFormOfInteger {
	public static void main(String[] args) {
		System.out.println(addToArrayForm(new int[] { 1, 2, 0, 0 }, 34));
		System.out.println(addToArrayForm(new int[] { 2, 7, 4 }, 181));
		System.out.println(addToArrayForm(new int[] { 2, 1, 5 }, 806));
		System.out.println(addToArrayForm(new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 }, 1));
	}

	public static List<Integer> addToArrayForm(int[] A, int K) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length; i++) {
			sb = sb.append(A[i]);
		}
		String val1 = sb.toString();
		String val2 = String.valueOf(K);
		int val1Index = val1.length() - 1;
		int val2Index = val2.length() - 1;
		boolean hasCarry = false;
		sb = new StringBuilder();
		while (val1Index > -1 || val2Index > -1) {
			int sum = hasCarry ? 1 : 0;
			hasCarry = false;
			if (val1Index > -1) {
				sum += Integer.parseInt(val1.charAt(val1Index) + "");
				val1Index--;
			}
			if (val2Index > -1) {
				sum += Integer.parseInt(val2.charAt(val2Index) + "");
				val2Index--;
			}
			if (sum > 9) {
				hasCarry = true;
				sum = sum - 10;
			}
			sb = sb.append(sum);
		}

		if (hasCarry) {
			sb = sb.append(1);
		}
		List<Integer> lst = new ArrayList<Integer>();
		String out = sb.toString();
		for (int i = out.length() - 1; i >= 0; i--) {
			lst.add(Integer.parseInt(out.charAt(i) + ""));
		}
		return lst;
	}
}
