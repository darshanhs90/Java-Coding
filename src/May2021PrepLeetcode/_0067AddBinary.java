package May2021PrepLeetcode;

public class _0067AddBinary {

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("1010", "1011"));
	}

	public static String addBinary(String a, String b) {
		int aIndex = a.length() - 1, bIndex = b.length() - 1;
		boolean hasCarry = false;
		StringBuilder sb = new StringBuilder();
		while (aIndex >= 0 || bIndex >= 0) {
			int sum = hasCarry ? 1 : 0;
			hasCarry = false;
			if (aIndex >= 0 && bIndex >= 0) {
				sum += Integer.parseInt(a.charAt(aIndex) + "");
				sum += Integer.parseInt(b.charAt(bIndex) + "");
				aIndex--;
				bIndex--;
			} else if (aIndex >= 0) {
				sum += Integer.parseInt(a.charAt(aIndex) + "");
				aIndex--;
			} else {
				sum += Integer.parseInt(b.charAt(bIndex) + "");
				bIndex--;
			}

			if (sum == 0 || sum == 1) {
				sb.append(sum);
			} else if (sum == 2) {
				hasCarry = true;
				sb.append("0");
			} else {
				hasCarry = true;
				sb.append("1");
			}
		}
		if (hasCarry) {
			sb.append("1");
		}
		return sb.reverse().toString();
	}
}
