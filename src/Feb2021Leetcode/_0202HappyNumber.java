package Feb2021Leetcode;

import java.util.HashSet;

public class _0202HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(19));
		System.out.println(isHappy(2));
	}

	public static boolean isHappy(int n) {
		String num = String.valueOf(n);
		HashSet<String> set = new HashSet<String>();
		while (!set.contains(num)) {
			if (num.equals("1"))
				return true;

			set.add(num);

			int newVal = 0;
			for (int i = 0; i < num.length(); i++) {
				int currNum = num.charAt(i) - '0';
				newVal += (currNum * currNum);
			}

			num = String.valueOf(newVal);
		}

		return false;
	}

}
