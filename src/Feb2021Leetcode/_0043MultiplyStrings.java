package Feb2021Leetcode;

public class _0043MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("2", "3"));
		System.out.println(multiply("123", "456"));
		System.out.println(multiply("140", "721"));
	}

	public static String multiply(String nums1, String nums2) {
		if (nums1.equals("0") || nums2.equals("0"))
			return "0";
		int[] mult = new int[nums1.length() + nums2.length()];
		for (int i = nums1.length() - 1; i >= 0; i--) {
			for (int j = nums2.length() - 1; j >= 0; j--) {
				int val1 = (nums1.charAt(i) - '0');
				int val2 = (nums2.charAt(j) - '0');

				int index1 = i + j + 1;
				int index2 = i + j;

				int val = val1 * val2 + mult[index1];
				mult[index1] = val % 10;
				mult[index2] += val / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mult.length; i++) {
			sb.append(mult[i]);
		}
		while (sb.length() > 0 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);

		return sb.toString();
	}
}
