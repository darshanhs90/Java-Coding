package Dec2020Leetcode;

import java.util.HashSet;

public class _0202HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}

	public static boolean isHappy(int n) {
		if (n == 1)
			return true;
		HashSet<Integer> set = new HashSet<Integer>();
		while (!set.contains(n)) {
			if (n == 1)
				return true;
			set.add(n);
			String str = String.valueOf(n);
			n = 0;
			for (int i = 0; i < str.length(); i++) {
				n += Math.pow((str.charAt(i) - '0'), 2);
			}
		}
		return false;
	}

}
