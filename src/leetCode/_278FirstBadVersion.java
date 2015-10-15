package leetCode;

/*
 * Link : https://leetcode.com/problems/first-bad-version/
 */

public class _278FirstBadVersion {
	static boolean[] badVersion=new boolean[]{false,false,false,false,false,true,true};
	public static int firstBadVersion(int n) {
		int start = 1;
		int end = n;
		int mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (isBadVersion(start)) {
			return start;
		}
		return end;
	}
	private static boolean isBadVersion(int mid) {
		return badVersion[mid];
	}
	public static void main(String[] args) {
		System.out.println(firstBadVersion(7));
	}

}