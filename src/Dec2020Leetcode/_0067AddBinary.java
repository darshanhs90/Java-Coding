package Dec2020Leetcode;

public class _0067AddBinary {

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("1010", "1011"));
	}

	public static String addBinary(String a, String b) {
		boolean hasCarry = false;
		int aIndex = a.length() - 1;
		int bIndex = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		while (aIndex >= 0 || bIndex >= 0) {
			int sum = 0;
			if (hasCarry) {
				sum = 1;
				hasCarry = false;
			}

			if (aIndex >= 0) {
				sum += Integer.parseInt(a.charAt(aIndex) + "");
				aIndex--;
			}
			if (bIndex >= 0) {
				sum += Integer.parseInt(b.charAt(bIndex) + "");
				bIndex--;
			}

			if (sum == 2) {
				sb.insert(0, "0");
				hasCarry = true;
			} else if (sum == 3) {
				sb.insert(0, "1");
				hasCarry = true;
			} else {
				sb.insert(0, sum);
			}
		}

		if (hasCarry)
			sb.insert(0, "1");

		return sb.toString();
	}
}
