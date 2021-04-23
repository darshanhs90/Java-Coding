package April2021PrepLeetcode;

import java.util.HashSet;

public class _00004LongestValidSubArray {
	public static void main(String[] args) {
		System.out.println((longestArray(new String[] { "P1", "P2", "D1", "D2" })));
		System.out.println((longestArray(new String[] { "P1", "D2", "D1", "P2" })));
		System.out.println((longestArray(new String[] { "P1", "D2" })));
		System.out.println((longestArray(new String[] { "P1", "P2" })));
		System.out.println((longestArray(new String[] { "P1", "D1", "D1" })));
		System.out.println((longestArray(new String[] {})));
		System.out.println((longestArray(new String[] { "P1", "P1", "D1" })));
		System.out.println((longestArray(new String[] { "P1", "P1", "D1", "D1" })));
		System.out.println((longestArray(new String[] { "P1", "D1", "P1" })));
		System.out.println((longestArray(new String[] { "P1", "D1", "P1", "D1" })));
	}

	public static int longestArray(String[] orders) {
		HashSet<String> pickups = new HashSet<String>();
		HashSet<String> deliveries = new HashSet<String>();
		int res = 0;
		int longest = 0;
		for (String order : orders) {
			char c = order.charAt(0);
			String str = order.substring(1);
			if (c == 'P') {
				if (pickups.contains(str)) {
					longest = 0;
					pickups.clear();
					deliveries.clear();
				}
				longest++;
				pickups.add(str);
			} else {
				if (deliveries.contains(str) || !pickups.contains(str)) {
					longest = 0;
					pickups.clear();
					deliveries.clear();
				} else {
					longest++;
					deliveries.add(str);
				}
			}
			res = Math.max(res, longest);
		}
		return res;
	}
}
