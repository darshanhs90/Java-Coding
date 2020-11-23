package Nov2020Leetcode;

import java.util.HashSet;

public class _0202HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}

	public static boolean isHappy(int n) {
		HashSet<Integer> visitedNumbers = new HashSet<Integer>();
		return isHappyNumber(n, visitedNumbers);
	}

	public static boolean isHappyNumber(int n, HashSet<Integer> numbers) {
		if (numbers.contains(n))
			return false;
		numbers.add(n);
		String str = String.valueOf(n);
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = Integer.parseInt(str.charAt(i) + "");
			sum += val * val;
		}
		if (sum == 1)
			return true;
		return isHappyNumber(sum, numbers);
	}
}
