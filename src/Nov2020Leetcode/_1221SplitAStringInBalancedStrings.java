package Nov2020Leetcode;

public class _1221SplitAStringInBalancedStrings {
	public static void main(String[] args) {
		System.out.println(balancedStringSplit("RLRRLLRLRL"));
		System.out.println(balancedStringSplit("RLLLLRRRLR"));
		System.out.println(balancedStringSplit("LLLLRRRR"));
		System.out.println(balancedStringSplit("RLRRRLLRLL"));
	}

	public static int balancedStringSplit(String s) {
		int count = 0;
		int balance = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'L') {
				balance++;
			} else {
				balance--;
			}
			if (balance == 0)
				count++;
		}
		return count;
	}
}
