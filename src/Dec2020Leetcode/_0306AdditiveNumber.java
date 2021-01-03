package Dec2020Leetcode;

public class _0306AdditiveNumber {

	public static void main(String[] args) {
		System.out.println(isAdditiveNumber("112358"));
		System.out.println(isAdditiveNumber("199100199"));
		System.out.println(isAdditiveNumber("123"));
		System.out.println(isAdditiveNumber("101"));
	}

	public static boolean isAdditiveNumber(String num) {
		if (num == null || num.length() < 3)
			return false;
		for (int i = 1; i <= num.length() / 2; i++) {
			String number1 = num.substring(0, i);
			if (number1.length() > 1 && number1.charAt(0) == '0')
				return false;
			Long num1 = Long.parseLong(num.substring(0, i));
			for (int j = 1; i + j < num.length(); j++) {
				String number2 = num.substring(i, i + j);
				if (number2.length() > 1 && number2.charAt(0) == '0')
					break;
				Long num2 = Long.parseLong(num.substring(i, i + j));
				String restString = num.substring(i + j);
				String sum = String.valueOf(num1 + num2);
				if (restString.startsWith(sum)) {
					if (isValid(num2, num1 + num2, i + j + sum.length(), num))
						return true;
				}

			}
		}
		return false;
	}

	public static boolean isValid(Long num1, Long num2, int newIndex, String num) {
		if (newIndex == num.length())
			return true;
		String sum = String.valueOf(num1 + num2);
		return num.substring(newIndex).startsWith(sum)
				&& isValid(num2, Long.parseLong(sum), newIndex + sum.length(), num);
	}

}
