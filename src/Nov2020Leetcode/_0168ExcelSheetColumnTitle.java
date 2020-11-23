package Nov2020Leetcode;

public class _0168ExcelSheetColumnTitle {
	public static void main(String[] args) {
		System.out.println(convertToTitle(1));
		System.out.println(convertToTitle(28));
		System.out.println(convertToTitle(701));
	}

	public static String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			n--;
			sb = sb.insert(0, (char) ('A' + n % 26));
			n = n / 26;
		}

		return sb.toString();
	}
}
