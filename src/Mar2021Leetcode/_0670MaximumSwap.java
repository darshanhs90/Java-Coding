package Mar2021Leetcode;

import java.util.HashMap;

public class _0670MaximumSwap {

	public static void main(String[] args) {
		System.out.println(maximumSwap(2736));
		System.out.println(maximumSwap(9973));
	}

	public static int maximumSwap(int num) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] cArr = String.valueOf(num).toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			map.put(cArr[i], i);
		}

		for (int i = 0; i < cArr.length; i++) {
			char currChar = cArr[i];
			for (char c = '9'; c >= '1'; c--) {
				if (c != currChar && c > currChar && map.containsKey(c) && map.get(c) > i) {

					cArr[i] = c;
					cArr[map.get(c)] = currChar;
					return Integer.parseInt(new String(cArr));
				}
			}
		}
		return num;
	}
}
