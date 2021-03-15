package Feb2021Leetcode;

public class _0443StringCompression {

	public static void main(String[] args) {
		System.out.println(compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
	}

	public static int compress(char[] chars) {
		if (chars == null || chars.length == 0)
			return 0;

		int index = 0;
		char prev = chars[0];
		int count = 1;
		for (int i = 1; i < chars.length; i++) {
			char currChar = chars[i];

			if (prev != currChar) {
				if (count == 1) {
					chars[index] = prev;
					index++;
				} else {
					String str = String.valueOf(count);
					chars[index] = prev;
					index++;
					for (int j = 0; j < str.length(); j++) {
						chars[index] = str.charAt(j);
						index++;
					}
				}
				prev = currChar;
				count = 1;
			} else {
				count++;
			}
		}
		if (count == 1) {
			chars[index] = prev;
			index++;
		} else {
			String str = String.valueOf(count);
			chars[index] = prev;
			index++;
			for (int j = 0; j < str.length(); j++) {
				chars[index] = str.charAt(j);
				index++;
			}
		}
		return index;
	}

}
