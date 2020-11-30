package Nov2020_FBPrep;

public class _055FirstBadVersion {

	public static void main(String[] args) {
		// System.out.println(firstBadVersion(5));
		System.out.println(firstBadVersion(1));
	}

	public static boolean isBadVersion(int n) {
		// return n >= 4;
		return n >= 1;
	}

	public static int firstBadVersion(int n) {
		int left = 1;
		int right = n;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (left == right)
				return left;
			else if (isBadVersion(mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
