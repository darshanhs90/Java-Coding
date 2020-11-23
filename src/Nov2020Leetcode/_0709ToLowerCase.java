package Nov2020Leetcode;

public class _0709ToLowerCase {
	public static void main(String[] args) {
		System.out.println(toLowerCase("Hello"));
		System.out.println(toLowerCase("here"));
		System.out.println(toLowerCase("LOVELY"));
		System.out.println(toLowerCase("al&phaBET"));
	}

	public static String toLowerCase(String str) {
		char[] cArr = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			char c = cArr[i];
			int val = (int) c;
			if (val >= 65 && val <= 90) {
				val = val + 32;
			}
			cArr[i] = (char) val;
		}
		return new String(cArr);
	}
}
