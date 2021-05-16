package May2021Leetcode;

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
			char c = chars[i];
			if (prevChar == c) {
				count++;
			} else {
				chars[index++] = prevChar;
				if (count != 1) {
					String val = String.valueOf(count);
					for (int j = 0; j < val.length(); j++) {
						chars[index++] = val.charAt(j);
					}
				}

				prevChar = c;
				count = 1;
			}
		}
		chars[index++] = prevChar;
		if (count != 1) {
			String val = String.valueOf(count);
			for (int j = 0; j < val.length(); j++) {
				chars[index++] = val.charAt(j);
			}
		}
		return index;
	}

}
