package April2021Leetcode;

public class _1359CountAllValidPickupAndDeliveryOptions {
	public static void main(String[] args) {
		System.out.println(countOrders(1));
		System.out.println(countOrders(2));
		System.out.println(countOrders(3));
	}

	public static int countOrders(int n) {
		long res = 1, mod = (long) 1e9 + 7;
		for (int i = 1; i <= n; i++) {
			res = res * i * (2 * i - 1) % mod;
		}
		return (int) res;
	}

}
