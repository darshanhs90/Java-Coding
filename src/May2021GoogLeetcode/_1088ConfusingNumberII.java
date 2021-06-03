package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1088ConfusingNumberII {

	public static void main(String[] args) {
		System.out.println(confusingNumberII(20));
		System.out.println(confusingNumberII(100));
		System.out.println(confusingNumberII(195));
	}

	public static int confusingNumberII(int n) {
		List<String> nos = new ArrayList<String>();
		String str = String.valueOf(n);
		for (int i = 1; i <= str.length(); i++) {
			nos.addAll(strobo(i, i));
		}
		int count = 0;
		List<String> temp = new ArrayList<String>();
		for (String num : nos) {
			if (num.length() > 1 && Integer.parseInt(num) <= n && isConfusing(num)) {
				count++;
			} else if (num.length() == 1 && Integer.parseInt(num) <= n && (num.equals("6") || num.equals("9"))) {
				count++;
			}
		}
		System.out.println(temp);
		return count;
	}

	public static boolean isConfusing(String str) {
		char[] cArr = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			switch (cArr[i]) {
			case '0':
				cArr[i] = '0';
				break;
			case '1':
				cArr[i] = '1';
				break;
			case '6':
				cArr[i] = '9';
				break;
			case '9':
				cArr[i] = '6';
				break;
			case '8':
				cArr[i] = '8';
				break;
			}
		}
		return !(new StringBuilder(new String(cArr)).reverse().toString().equals(str));
	}

	public static List<String> strobo(int m, int n) {
		if (m == 0)
			return new ArrayList<String>(Arrays.asList(""));
		if (m == 1)
			return new ArrayList<String>(Arrays.asList("0", "1", "8", "6", "9"));
		List<String> list = strobo(m - 2, n);
		List<String> out = new ArrayList<String>();
		for (String str : list) {
			if (str.length() > 0 && m != n) {
				out.add("0" + str + "0");
				out.add("0" + str + "1");
				out.add("0" + str + "6");
				out.add("0" + str + "9");
				out.add("0" + str + "8");
			}

			out.add("1" + str + "0");
			out.add("1" + str + "1");
			out.add("1" + str + "6");
			out.add("1" + str + "9");
			out.add("1" + str + "8");

			out.add("6" + str + "0");
			out.add("6" + str + "1");
			out.add("6" + str + "6");
			out.add("6" + str + "9");
			out.add("6" + str + "8");

			out.add("9" + str + "0");
			out.add("9" + str + "1");
			out.add("9" + str + "6");
			out.add("9" + str + "9");
			out.add("9" + str + "8");

			out.add("8" + str + "0");
			out.add("8" + str + "1");
			out.add("8" + str + "6");
			out.add("8" + str + "9");
			out.add("8" + str + "8");
		}
		return out;
	}
}
