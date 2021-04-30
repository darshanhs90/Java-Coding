package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0247StrobogrammaticNumberII {

	public static void main(String[] args) {
		System.out.println(findStrobogrammatic(2));
		System.out.println(findStrobogrammatic(3));
	}

	public static List<String> findStrobogrammatic(int n) {
		return strobo(n, n);
	}

	public static List<String> strobo(int m, int n) {
		if (m <= 0)
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
