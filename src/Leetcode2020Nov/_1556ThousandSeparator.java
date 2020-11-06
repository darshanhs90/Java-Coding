package Leetcode2020Nov;

public class _1556ThousandSeparator {
	public static void main(String[] args) {
		System.out.println(thousandSeparator(987));
		System.out.println(thousandSeparator(1234));
		System.out.println(thousandSeparator(123456789));
		System.out.println(thousandSeparator(0));
	}

	public static String thousandSeparator(int n) {
		StringBuilder sb = new StringBuilder();
		String str = String.valueOf(n);
		int count = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if(count == 3)
			{
				sb = sb.append(".");
				count = 1;
			}
			else {
				count++;
			}
			sb = sb.append(str.charAt(i));
		}
		return sb.reverse().toString();
	}
}
