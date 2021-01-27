package Dec2020Leetcode;

import java.util.Arrays;

public class _0670MaximumSwap {

	public static void main(String[] args) {
		System.out.println(maximumSwap(2736));
		System.out.println(maximumSwap(9973));
	}

	public static int maximumSwap(int num) {
		int[] lastIndex = new int[10];
		Arrays.fill(lastIndex, -1);
		String str = String.valueOf(num);
		for (int i = 0; i < str.length(); i++) {
			lastIndex[str.charAt(i) - '0'] = i;
		}

		char[] cArr = str.toCharArray();

		for (int i = 0; i < cArr.length; i++) {
			char currChar = cArr[i];
			if (cArr[i] == 9)
				continue;
			for (char j = '9'; j > currChar; j--) {
				if (lastIndex[j - '0'] > i) {
					int newIndex = lastIndex[j - '0'];
					cArr[newIndex] = currChar;
					cArr[i] = j;
					return Integer.valueOf(new String(cArr));
				}
			}
		}
		return num;
	}
}
