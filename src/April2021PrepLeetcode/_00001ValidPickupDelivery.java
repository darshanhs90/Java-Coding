package April2021PrepLeetcode;

import java.util.HashMap;
import java.util.Map;

public class _00001ValidPickupDelivery {
	public static void main(String[] args) {
		System.out.println(isValidOrder(new String[] { "P1", "P2", "D1", "D2" }));// true
		System.out.println(isValidOrder(new String[] { "P1", "D2", "D1", "P2" }));// false
		System.out.println(isValidOrder(new String[] { "P1", "D2" }));// false
		System.out.println(isValidOrder(new String[] { "P1", "P2" }));// false
		System.out.println(isValidOrder(new String[] { "P1", "D1", "D1" }));// false
		System.out.println(isValidOrder(new String[] {}));// true
		System.out.println(isValidOrder(new String[] { "P1", "P1", "D1" }));// False
		System.out.println(isValidOrder(new String[] { "P1", "P1", "D1", "D1" }));// False
		System.out.println(isValidOrder(new String[] { "P1", "D1", "P1" }));// False
		System.out.println(isValidOrder(new String[] { "P1", "D1", "P1", "D1" }));// False
	}

	public static boolean isValidOrder(String[] strList) {
		if (strList == null || strList.length == 0)
			return true;
		if (strList.length % 2 != 0)
			return false;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// value - 0 - pickedup
		// value - 1 - delivered

		for (String str : strList) {
			char c = str.charAt(0);
			int index = Integer.parseInt(str.substring(1));
			if (c == 'P') {
				if (map.containsKey(index))
					return false;
				map.put(index, 0);
			} else {
				if (!map.containsKey(index))
					return false;

				if (map.get(index) == 1)
					return false;
				map.put(index, 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 0)
				return false;
		}

		return true;
	}
}
