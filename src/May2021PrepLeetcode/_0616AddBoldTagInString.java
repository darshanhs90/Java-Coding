package May2021PrepLeetcode;

public class _0616AddBoldTagInString {

	public static void main(String[] args) {
		System.out.println(addBoldTag("abcxyz123", new String[] { "abc", "123" }));
		System.out.println(addBoldTag("aaabbcc", new String[] { "aaa", "aab", "bc" }));
	}

	public static String addBoldTag(String s, String[] dict) {
		boolean bold[] = new boolean[s.length()];

		for (int i = 0; i < s.length(); i++) {
			String subString = s.substring(i);
			for (int j = 0; j < dict.length; j++) {
				if (subString.startsWith(dict[j])) {
					String str = dict[j];
					for (int k = i; k < i + str.length(); k++) {
						bold[k] = true;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bold.length;) {
			if (!bold[i]) {
				sb.append(s.charAt(i));
				i++;
			} else {
				sb.append("<b>");
				while (i < bold.length && bold[i]) {
					sb.append(s.charAt(i));
					i++;
				}
				sb.append("</b>");
			}
		}
		return sb.toString();
	}
}
