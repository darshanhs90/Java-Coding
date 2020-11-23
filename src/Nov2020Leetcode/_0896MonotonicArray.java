package Nov2020Leetcode;

public class _0896MonotonicArray {
	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[] { 1, 2, 2, 3 }));
		System.out.println(isMonotonic(new int[] { 6, 5, 4, 4 }));
		System.out.println(isMonotonic(new int[] { 1, 3, 2 }));
		System.out.println(isMonotonic(new int[] { 1, 2, 4, 5 }));
		System.out.println(isMonotonic(new int[] { 1, 1, 1 }));
	}

	enum Order {
		Undefined, Increasing, Descreasing
	}

	public static boolean isMonotonic(int[] A) {
		Order order = Order.Undefined;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1] && (order == Order.Descreasing || order == Order.Undefined)) {
				order = Order.Descreasing;
			} else if (A[i] > A[i - 1] && (order == Order.Increasing || order == Order.Undefined)) {
				order = Order.Increasing;
			} else if (A[i] != A[i - 1]) {
				return false;
			}
		}
		return true;
	}
}
