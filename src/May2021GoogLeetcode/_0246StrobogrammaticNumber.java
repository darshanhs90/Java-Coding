package May2021GoogLeetcode;

public class _0246StrobogrammaticNumber {

	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("69"));
		System.out.println(isStrobogrammatic("88"));
		System.out.println(isStrobogrammatic("962"));
		System.out.println(isStrobogrammatic("1"));
	}

	public static boolean isStrobogrammatic(String num) {
		StringBuilder sb = new StringBuilder();
		char[] cArr = num.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			char c = cArr[i];
			if (c == '0' || c == '1' || c == '8') {
				sb.append(c);
			} else if (c == '6') {
				sb.append('9');
			} else if (c == '9') {
				sb.append('6');
			} else {
				return false;
			}
		}
		return sb.reverse().toString().equals(num);
	}
}
