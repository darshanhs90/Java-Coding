package Mar2021Leetcode;

public class _0443StringCompression {

	public static void main(String[] args) {
		System.out.println(compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
	}

	public static int compress(char[] chars) {
		if (chars == null || chars.length == 0)
			return 0;

		int index = 0;
		int count = 1;
		char prev = chars[0];
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == prev) {
				count++;
			} else {

				if (count > 1) {
					String str = String.valueOf(count);
					chars[index++] = prev;
					for (int j = 0; j < str.length(); j++) {
						chars[index++] = str.charAt(j);
					}
				} else {
					chars[index] = prev;
					index++;
				}

				prev = chars[i];
				count = 1;
			}
		}

		if (count > 1) {
			String str = String.valueOf(count);
			chars[index++] = prev;
			for (int j = 0; j < str.length(); j++) {
				chars[index++] = str.charAt(j);
			}
		} else {
			chars[index] = prev;
			index++;
		}
		return index;
	}

}
