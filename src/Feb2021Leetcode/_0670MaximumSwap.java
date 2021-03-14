package Feb2021Leetcode;

import java.util.HashMap;

public class _0670MaximumSwap {

	public static void main(String[] args) {
		System.out.println(maximumSwap(2736));
		System.out.println(maximumSwap(9973));
	}

	public static int maximumSwap(int num) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String str = String.valueOf(num);
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), i);
		}

		char[] cArr = str.toCharArray();

		for (int i = 0; i < cArr.length; i++) {
			char originalChar = cArr[i];
			for (char c = '9'; c >= '1'; c--) {
				if (c > originalChar && map.containsKey(c) && map.get(c) > i) {
					cArr[i] = c;
					cArr[map.get(c)] = originalChar;
					return Integer.parseInt(new String(cArr));
				}
			}
		}
		return num;
	}
}
