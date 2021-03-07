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
		int[] out = new int[nums1.length() + nums2.length()];
		for (int i = nums1.length() - 1; i >= 0; i--) {
			for (int j = nums2.length() - 1; j >= 0; j--) {
				int num1 = Integer.parseInt(nums1.charAt(i) + "");
				int num2 = Integer.parseInt(nums2.charAt(j) + "");

				int index1 = i + j + 1;
				int index2 = i + j;

				int mult = num1 * num2 + out[index1];

				out[index1] = mult % 10;
				out[index2] += mult / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < out.length; i++) {
			sb.append(out[i] + "");
		}

		while (sb.length() > 0 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
	}
}
