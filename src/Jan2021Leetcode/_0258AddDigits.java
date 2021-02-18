package Jan2021Leetcode;

public class _0258AddDigits {

	public static void main(String[] args) {
		System.out.println(addDigits(38));
	}

	public static int addDigits(int num) {
		String str = String.valueOf(num);
		while (str.length() > 1) {
			int val = 0;
			for (int i = 0; i < str.length(); i++) {
				val += str.charAt(i) - '0';
			}
			str = String.valueOf(val);
		}
		return Integer.parseInt(str);
	}

}
