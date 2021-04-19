package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _1359CountAllValidPickupAndDeliveryOptions {
	public static void main(String[] args) {
		System.out.println(countOrders(1));
		System.out.println(countOrders(2));
		System.out.println(countOrders(3));

		System.out.println(generate(1));
		System.out.println(generate(2));
		System.out.println(generate(3));
	}

	public static int countOrders(int n) {
		long res = 1, mod = (long) (1e9 + 7);
		for (int i = 1; i <= n; i++) {
			res = res * i * (2 * i - 1) % mod;
		}
		return (int) (res % mod);
	}

	public static int generate(int n) {
		List<String> pickup = new ArrayList<>();
		List<String> delivery = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			String p = "P" + i;
			String d = "D" + i;
			pickup.add(p);
			delivery.add(d);
		}
		List<List<String>> res = new ArrayList<>();
		getCombos(pickup, delivery, res, new ArrayList<>(), new boolean[n], new boolean[n]);
		System.out.println(res);
		return res.size();
	}

	public static void getCombos(List<String> pickup, List<String> delivery, List<List<String>> res, List<String> curr,
			boolean[] picked, boolean[] delivered) {
		if (curr.size() == pickup.size() * 2)
			res.add(new ArrayList<>(curr));

		for (int i = 0; i < pickup.size(); i++) {
			if (!picked[i]) {
				curr.add(pickup.get(i));
				picked[i] = true;
				getCombos(pickup, delivery, res, curr, picked, delivered);
				curr.remove(curr.size() - 1);
				picked[i] = false;
			}
		}
		for (int i = 0; i < delivery.size(); i++) {
			if (picked[i] && !delivered[i]) {
				curr.add(delivery.get(i));
				delivered[i] = true;
				getCombos(pickup, delivery, res, curr, picked, delivered);
				curr.remove(curr.size() - 1);
				delivered[i] = false;
			}
		}
	}

}
