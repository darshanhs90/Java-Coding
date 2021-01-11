package Dec2020Leetcode;

public class _1576ReplaceAllQnMarksToAvoidConsecutiveRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(modifyString("?zs"));
		System.out.println(modifyString("ubv?w"));
		System.out.println(modifyString("j?qg??b"));
		System.out.println(modifyString("??yw?ipkj?"));
		System.out.println(modifyString("a?"));
	}

	public static String modifyString(String s) {
		int right = 0;
		char[] cArr = s.toCharArray();
		Character prevChar = null;
		while (right < s.length()) {
			char c = cArr[right];
			if (c != '?') {
				prevChar = cArr[right];
				right++;
				continue;
			} else {

				if (right + 1 < s.length() && cArr[right + 1] == '?') {
					if (prevChar == null)
						cArr[right] = 'a';
					else {
						if (prevChar != 'z')
							cArr[right] = 'z';
						else {
							cArr[right] = 'a';
						}
					}
				} else {
					if (right + 1 == s.length()) {
						if (prevChar == null)
							cArr[right] = 'a';
						else {
							if (prevChar != 'z')
								cArr[right] = 'z';
							else {
								cArr[right] = 'a';
							}
						}
					} else {
						char nextChar = cArr[right + 1];
						if (prevChar == null) {
							if (nextChar != 'z')
								cArr[right] = 'z';
							else {
								cArr[right] = 'a';
							}
						} else {
							for (char c1 = 'a'; c1 <= 'z'; c1++) {
								if (c1 != prevChar && c1 != nextChar) {
									cArr[right] = c1;
									break;
								}
							}
						}
					}
				}

			}
			prevChar = cArr[right];
			right++;
		}
		return new String(cArr);
	}
}
