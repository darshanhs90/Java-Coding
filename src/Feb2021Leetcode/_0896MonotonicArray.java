package Feb2021Leetcode;

public class _0896MonotonicArray {
	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[] { 1, 2, 2, 3 }));
		System.out.println(isMonotonic(new int[] { 6, 5, 4, 4 }));
		System.out.println(isMonotonic(new int[] { 1, 3, 2 }));
		System.out.println(isMonotonic(new int[] { 1, 2, 4, 5 }));
		System.out.println(isMonotonic(new int[] { 1, 1, 1 }));
	}

	static enum Order {
		Increasing, Decreasing, NotDefined
	}

	public static boolean isMonotonic(int[] A) {
		Order currOrder = Order.NotDefined;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1]) {
				if (currOrder != Order.Decreasing) {
					currOrder = Order.Increasing;
				} else {
					return false;
				}
			} else if (A[i] < A[i - 1]) {
				if (currOrder != Order.Increasing) {
					currOrder = Order.Decreasing;
				} else {
					return false;
				}
			}
		}
		return true;
	}

}
