package Feb2021Leetcode;

import java.util.HashMap;

public class _0670MaximumSwap {

	public static void main(String[] args) {
		System.out.println(maximumSwap(2736));
		System.out.println(maximumSwap(9973));
	}

	public static int maximumSwap(int num) {
		String str = String.valueOf(num);
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			map.put(c, i);
		}

		char[] cArr = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			for (char c = '9'; c >= '1'; c--) {
				if (c > cArr[i] && map.containsKey(c) && map.get(c) > i) {
					char temp = cArr[i];
					cArr[i] = c;
					cArr[map.get(c)] = temp;
					return Integer.parseInt(new String(cArr));
				}
			}
		}
		return num;
	}
}
