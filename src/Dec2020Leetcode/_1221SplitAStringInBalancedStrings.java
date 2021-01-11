package Dec2020Leetcode;

public class _1221SplitAStringInBalancedStrings {
	public static void main(String[] args) {
		System.out.println(balancedStringSplit("RLRRLLRLRL"));
		System.out.println(balancedStringSplit("RLLLLRRRLR"));
		System.out.println(balancedStringSplit("LLLLRRRR"));
		System.out.println(balancedStringSplit("RLRRRLLRLL"));
	}

	public static int balancedStringSplit(String s) {
		int currCount = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'L')
				currCount++;
			else
				currCount--;
			if (currCount == 0)
				count++;
		}
		return count;
	}
}
