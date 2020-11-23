package Nov2020Leetcode;

public class _0541ReverseStringII {

	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefg", 2));
	}

	public static String reverseStr(String s, int k) {
		int count = 0;
		boolean reverse = true;
		StringBuilder out = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (count < k) {
				sb = sb.append(s.charAt(i));
				count++;
			}

			if (count == k && reverse == true) {
				out = out.append(sb.reverse().toString());
				reverse = false;
				sb = new StringBuilder();
				count = 0;
			} else if (count == k && reverse == false) {
				out = out.append(sb.toString());
				reverse = true;
				sb = new StringBuilder();
				count = 0;
			}
		}
		if (reverse == true) {
			out = out.append(sb.reverse().toString());
		} else if (reverse == false) {
			out = out.append(sb.toString());
		}

		return out.toString();
	}
}
