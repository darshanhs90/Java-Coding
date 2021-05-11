package May2021Leetcode;

public class _0896MonotonicArray {
	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[] { 1, 2, 2, 3 }));
		System.out.println(isMonotonic(new int[] { 6, 5, 4, 4 }));
		System.out.println(isMonotonic(new int[] { 1, 3, 2 }));
		System.out.println(isMonotonic(new int[] { 1, 2, 4, 5 }));
		System.out.println(isMonotonic(new int[] { 1, 1, 1 }));
	}

	static enum Change {
		Increasing, Decreasing, None
	}

	public static boolean isMonotonic(int[] A) {
		if (A == null || A.length < 2)
			return true;
		Change change = Change.None;

		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1]) {
				if (change == Change.Decreasing)
					return false;
				change = Change.Increasing;
			} else if (A[i] < A[i - 1]) {
				if (change == Change.Increasing)
					return false;
				change = Change.Decreasing;
			}
		}
		return true;
	}

}
