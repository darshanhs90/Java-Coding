package Nov2020Leetcode;

import java.util.Arrays;

public class _1576ReplaceAllQnMarksToAvoidConsecutiveRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println((int) 'z');
		System.out.println(modifyString("?zs"));
		System.out.println(modifyString("ubv?w"));
		System.out.println(modifyString("j?qg??b"));
		System.out.println(modifyString("??yw?ipkj?"));
	}

	public static String modifyString(String s) {
		char[] outArr = s.toCharArray();
		int[] charArr = new int[26];
		Arrays.fill(charArr, 0);
		int leftIndex = -1;
		int rightIndex = s.length();
		boolean rightSearch = false;
		for (int i = 0; i < outArr.length; i++) {
			char c = outArr[i];
			if (c == '?') {
				rightSearch = true;
				if (leftIndex == -1) {
					leftIndex = i;
				}
			} else if (rightSearch == true) {
				rightIndex = i;
				if (leftIndex - 1 > -1 && outArr[leftIndex - 1] != '?') {
					charArr[outArr[leftIndex - 1] - 97] = 1;
				}
				if (rightIndex < outArr.length && outArr[rightIndex] != '?') {
					charArr[outArr[rightIndex] - 97] = 1;
				}
				// populate chararr
				for (int j = leftIndex; j < rightIndex; j++) {
					Character charVal = null;
					for (int j2 = 0; j2 < charArr.length; j2++) {
						if (charArr[j2] == 0) {
							charVal = (char) (j2 + 97);
							charArr[j2] = 1;
							break;
						}
					}
					outArr[j] = charVal;
				}
				Arrays.fill(charArr, 0);
				leftIndex = -1;
				rightIndex = outArr.length;
				rightSearch = false;
			}
		}
		if (leftIndex != -1) {
			if (leftIndex - 1 > -1 && outArr[leftIndex - 1] != '?') {
				charArr[outArr[leftIndex - 1] - 97] = 1;
			}
			if (rightIndex < outArr.length && outArr[rightIndex] != '?') {
				charArr[outArr[rightIndex] - 97] = 1;
			}
			for (int j = leftIndex; j < outArr.length; j++) {
				Character charVal = null;
				for (int j2 = 0; j2 < charArr.length; j2++) {
					if (charArr[j2] == 0) {
						charVal = (char) (j2 + 97);
						charArr[j2] = 1;
						break;
					}
				}
				if (charVal == null) {
					Arrays.fill(charArr, 0);
					if (leftIndex - 1 > -1 && outArr[leftIndex - 1] != '?') {
						charArr[outArr[leftIndex - 1] - 97] = 1;
					}
					if (rightIndex < outArr.length && outArr[rightIndex] != '?') {
						charArr[outArr[rightIndex] - 97] = 1;
					}
					j--;
				} else {
					outArr[j] = charVal;
				}
			}
		}
		return new String(outArr);
	}
}
