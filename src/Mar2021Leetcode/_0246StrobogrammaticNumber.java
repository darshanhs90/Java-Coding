package Mar2021Leetcode;

public class _0246StrobogrammaticNumber {

	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("69"));
		System.out.println(isStrobogrammatic("88"));
		System.out.println(isStrobogrammatic("962"));
		System.out.println(isStrobogrammatic("1"));
	}

	public static boolean isStrobogrammatic(String num) {
		char[] cArr = num.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			char c = cArr[i];
			switch (c) {
			case '0':
				break;
			case '1':
				break;
			case '8':
				break;
			case '6':
				cArr[i] = '9';
				break;
			case '9':
				cArr[i] = '6';
				break;
			default:
				return false;
			}
		}
		String str = new StringBuilder(num).reverse().toString();
		return str.equals(new String(cArr));
	}
}
