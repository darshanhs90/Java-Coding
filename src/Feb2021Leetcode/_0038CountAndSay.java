package Feb2021Leetcode;

public class _0038CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(4));
	}

	public static String countAndSay(int n) {
		if (n < 1)
			return "";
		if (n == 1)
			return "1";
		String str = "1";
		for (int i = 1; i < n; i++) {

			char prev = str.charAt(0);
			int count = 1;
			StringBuilder sb = new StringBuilder();
			for (int j = 1; j < str.length(); j++) {
				char c = str.charAt(j);

				if (c == prev) {
					count++;
				} else {
					sb.append(count + "" + prev);
					prev = c;
					count = 1;
				}
			}
			sb.append(count + "" + prev);
			str = sb.toString();
		}
		return str;
	}

}
