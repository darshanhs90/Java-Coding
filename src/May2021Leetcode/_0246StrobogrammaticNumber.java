package May2021Leetcode;

public class _0246StrobogrammaticNumber {

	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("69"));
		System.out.println(isStrobogrammatic("88"));
		System.out.println(isStrobogrammatic("962"));
		System.out.println(isStrobogrammatic("1"));
	}

	public static boolean isStrobogrammatic(String num) {
		String str = num;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			if (c == '1' || c == '0' || c == '8') {
				sb.append(c);
			} else if (c == '6') {
				sb.append('9');
			} else if (c == '9') {
				sb.append('6');
			} else {
				return false;
			}
		}
		return sb.reverse().toString().equals(str);
	}
}
