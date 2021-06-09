package June2021GoogLeetcode;

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
		List<String> numbers = new ArrayList<String>();
		for (int i = 1; i <= String.valueOf(n).length(); i++) {
			numbers.addAll(strobo(i, i));
		}
		int count = 0;

		for (String num : numbers) {
			int val = Integer.parseInt(num);
			if (isDifferent(num) && val<n)
				count++;
		}

		return count;
	}

	public static boolean isDifferent(String num) {
		int val = Integer.parseInt(num);
		char[] cArr = num.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			char c = cArr[i];
			switch (c) {
			case '0':
			case '1':
			case '8':
				cArr[i] = c;
				break;
			case '6':
				cArr[i] = '9';
				break;
			case '9':
				cArr[i] = '6';
				break;
			}
		}

		String rev = new StringBuilder(new String(cArr)).reverse().toString();
		int revVal = Integer.parseInt(rev);
		return val != revVal;
	}

	public static List<String> strobo(int m, int n) {
		if (m == 0) {
			return new ArrayList<String>(Arrays.asList(""));
		}
		if (m == 1) {
			return new ArrayList<String>(Arrays.asList("0", "1", "6", "8", "9"));
		}

		List<String> list = strobo(m - 2, n);
		List<String> newList = new ArrayList<String>();

		for (String str : list) {
			if (m != n) {
				newList.add("0" + str + "0");
				newList.add("0" + str + "1");
				newList.add("0" + str + "6");
				newList.add("0" + str + "8");
				newList.add("0" + str + "9");
			}
			newList.add("1" + str + "0");
			newList.add("1" + str + "1");
			newList.add("1" + str + "6");
			newList.add("1" + str + "8");
			newList.add("1" + str + "9");

			newList.add("6" + str + "0");
			newList.add("6" + str + "1");
			newList.add("6" + str + "6");
			newList.add("6" + str + "8");
			newList.add("6" + str + "9");

			newList.add("8" + str + "0");
			newList.add("8" + str + "1");
			newList.add("8" + str + "6");
			newList.add("8" + str + "8");
			newList.add("8" + str + "9");

			newList.add("9" + str + "0");
			newList.add("9" + str + "1");
			newList.add("9" + str + "6");
			newList.add("9" + str + "8");
			newList.add("9" + str + "9");
		}
		return newList;
	}
}
