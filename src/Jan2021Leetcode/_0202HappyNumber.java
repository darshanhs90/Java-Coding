package Jan2021Leetcode;

import java.util.HashSet;

public class _0202HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}

	public static boolean isHappy(int n) {
		HashSet<String> visited = new HashSet<String>();
		String str = String.valueOf(n);
		while (!str.equals("1")) {
			if (visited.contains(str))
				return false;
			visited.add(str);
			int value = 0;
			for (int i = 0; i < str.length(); i++) {
				int subVal = str.charAt(i) - '0';
				value += subVal * subVal;
			}
			str = String.valueOf(value);
		}
		return true;
	}

}
