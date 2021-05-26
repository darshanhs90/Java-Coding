package May2021GoogLeetcode;

public class _0278FirstBadVersion {

	public static void main(String[] args) {
		System.out.println(firstBadVersion(2126753390));
	}

	public static boolean isBadVersion(int n) {
		return n > 2126753390 / 2;
	}

	public static int firstBadVersion(int n) {
		int left = 1, right = n;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (isBadVersion(mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

}
