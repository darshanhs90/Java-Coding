package April2021PrepLeetcode;

public class _0038CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(4));
	}

	public static String countAndSay(int n) {
		if (n <= 0)
			return "";
		String str = "1";
		for (int i = 1; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			char prevChar = str.charAt(0);
			for (int j = 1; j < str.length(); j++) {
				char currChar = str.charAt(j);
				if (currChar == prevChar) {
					count++;
				} else {
					sb.append(count);
					sb.append(prevChar);
					prevChar = currChar;
					count = 1;
				}
			}
			sb.append(count);
			sb.append(prevChar);
			str = sb.toString();
		}
		return str;
	}

}
