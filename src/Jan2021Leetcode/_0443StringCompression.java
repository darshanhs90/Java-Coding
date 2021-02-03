package Jan2021Leetcode;

import java.util.Arrays;

public class _0443StringCompression {

	public static void main(String[] args) {
		System.out.println(compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
	}

	public static int compress(char[] chars) {
		int left = 0;
		int right = 0;
		while (right < chars.length) {
			int count = 0;
			char currChar = chars[right];
			while (right < chars.length && currChar == chars[right]) {
				count++;
				right++;
			}

			chars[left] = currChar;
			left++;

			if (count > 1 && count < 10) {
				chars[left] = (char) (count + '0');
				left++;
			} else if (count >= 10) {
				String str = String.valueOf(count);
				for (int i = 0; i < str.length(); i++) {
					chars[left] = str.charAt(i);
					left++;
				}
			}
		}
		System.out.println(Arrays.toString(chars));
		return left;
	}

}
