package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0248StrobogrammaticNumberIII {

	public static void main(String[] args) {
		System.out.println(strobogrammaticInRange("50", "100"));
		System.out.println(strobogrammaticInRange("0", "0"));
	}

	public static int strobogrammaticInRange(String low, String high) {

		List<String> list = new ArrayList<String>();
		for (int i = low.length(); i <= high.length(); i++) {
			list.addAll(strobo(i, i));
		}

		int count = 0;
		for (String num : list) {
			if ((num.length() == low.length() && num.compareTo(low) < 0)
					|| (num.length() == high.length() && num.compareTo(high) > 0))
				continue;
			count++;
		}
		return count;
	}

	public static List<String> strobo(int m, int n) {
		if (m == 0)
			return new ArrayList<String>(Arrays.asList(""));
		if (m == 1)
			return new ArrayList<String>(Arrays.asList("0", "1", "8"));

		List<String> list = strobo(m - 2, n);
		List<String> out = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			if (m != n) {
				out.add("0" + str + "0");
			}

			out.add("1" + str + "1");
			out.add("6" + str + "9");
			out.add("9" + str + "6");
			out.add("8" + str + "8");
		}
		return out;
	}

}
