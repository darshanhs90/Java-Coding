package Leetcode2020Nov;

public class _0278FirstBadVersion {

	public static void main(String[] args) {
		System.out.println(firstBadVersion(2126753390));
	}

	public static boolean isBadVersion(int val) {
		return val > 1702766719;
	}

	public static int firstBadVersion(int n) {
		int startIndex = 1;
		int endIndex = n;
		while (startIndex < endIndex) {
			int val = startIndex + (-startIndex + endIndex) / 2;
			if (isBadVersion(val)) {
				endIndex = val;
			} else {
				startIndex = val + 1;
			}
		}
		return startIndex;
	}
}
