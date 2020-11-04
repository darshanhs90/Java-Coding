package Leetcode2020Nov;

public class _0258AddDigits {

	public static void main(String[] args) {
		System.out.println(addDigits(38));
	}

	public static int addDigits(int num) {
		if (num < 10)
			return num;
		String str = String.valueOf(num);
		int newNum = 0;
		for (int i = 0; i < str.length(); i++) {
			newNum += Integer.parseInt(str.charAt(i) + "");
		}
		return addDigits(newNum);
	}
}
