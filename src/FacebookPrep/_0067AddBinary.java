package FacebookPrep;

public class _0067AddBinary {

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("1010", "1011"));
	}

	public static String addBinary(String a, String b) {
		boolean hasCarry = false;
		int aIndex = a.length() - 1;
		int bIndex = b.length() - 1;
		char aChar[] = a.toCharArray();
		char bChar[] = b.toCharArray();
		StringBuilder sb = new StringBuilder();
		while (aIndex >= 0 || bIndex >= 0) {
			int sum = hasCarry ? 1 : 0;
			hasCarry = false;
			if (aIndex >= 0 && bIndex >= 0) {
				int val1 = aChar[aIndex] - '0';
				int val2 = bChar[bIndex] - '0';
				sum += val1 + val2;
			} else if (aIndex >= 0) {
				int val1 = aChar[aIndex] - '0';
				sum += val1;
			} else {
				int val2 = bChar[bIndex] - '0';
				sum += val2;
			}

			if (sum < 2) {
				sb.append(sum);
			} else if (sum == 2) {
				sb.append("0");
				hasCarry = true;
			} else {
				sb.append("1");
				hasCarry = true;
			}
			aIndex--;
			bIndex--;
		}

		if (hasCarry)
			sb.append("1");
		return sb.reverse().toString();
	}
}
