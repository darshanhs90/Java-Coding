package Dec2020Leetcode;

import java.util.Arrays;

public class _0443StringCompression {

	public static void main(String[] args) {
		System.out.println(compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
	}

	public static int compress(char[] chars) {
		if (chars == null || chars.length == 0)
			return 0;

		char prevChar = chars[0];
		int count = 1;
		int index = 0;
		for (int i = 1; i < chars.length; i++) {
			char currChar = chars[i];
			if (currChar == prevChar)
				count++;
			else {
				chars[index] = prevChar;
				index++;
				if (count > 1) {
					String str = String.valueOf(count);
					for (int j = 0; j < str.length(); j++) {
						chars[index] = str.charAt(j);
						index++;
					}
				}
				prevChar = currChar;
				count = 1;
			}
		}

		chars[index] = prevChar;
		index++;
		if (count > 1) {
			String str = String.valueOf(count);
			for (int j = 0; j < str.length(); j++) {
				chars[index] = str.charAt(j);
				index++;
			}
		}
		System.out.println(Arrays.toString(chars));

		return index;
	}

}
