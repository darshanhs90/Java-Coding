package Mar2021Leetcode;

public class _0038CountAndSay {

	public static void main(String[] args) {
		//System.out.println(countAndSay(1));
		System.out.println(countAndSay(4));
	}

	public static String countAndSay(int n) {
		String str = String.valueOf("1");
		for (int i = 1; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			char prev = str.charAt(0);
			int count = 1;
			for (int j = 1; j < str.length(); j++) {
				char currChar = str.charAt(j);
				if (currChar == prev) {
					count++;
				} else {
					sb.append(count);
					sb.append(prev);
					prev = currChar;
					count = 1;
				}
			}
			sb.append(count + "" + prev);
			str = sb.toString();
		}
		return str;
	}

}
