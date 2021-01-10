package Dec2020Leetcode;

public class _0896MonotonicArray {
	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[] { 1, 2, 2, 3 }));
		System.out.println(isMonotonic(new int[] { 6, 5, 4, 4 }));
		System.out.println(isMonotonic(new int[] { 1, 3, 2 }));
		System.out.println(isMonotonic(new int[] { 1, 2, 4, 5 }));
		System.out.println(isMonotonic(new int[] { 1, 1, 1 }));
	}

	enum Change {
		Increasing, Decreasing, None
	}

	public static boolean isMonotonic(int[] A) {
		Change c = Change.None;

		for (int i = 0; i < A.length - 1; i++) {
			if (c == Change.None) {
				if (A[i + 1] > A[i]) {
					c = Change.Increasing;
				} else if (A[i + 1] < A[i]) {
					c = Change.Decreasing;
				}
			} else if (c == Change.Increasing) {
				if (A[i + 1] < A[i]) {
					return false;
				}
			} else {
				if (A[i + 1] > A[i]) {
					return false;
				}
			}
		}
		return true;
	}

}
