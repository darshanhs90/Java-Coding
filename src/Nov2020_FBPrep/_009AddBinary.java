package Nov2020_FBPrep;

public class _009AddBinary {

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("1010", "1011"));
	}

	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		boolean hasCarry = false;
		int aIndex = a.length() - 1;
		int bIndex = b.length() - 1;
		while (aIndex >= 0 || bIndex >= 0) {
			int sum = hasCarry ? 1 : 0;
			hasCarry = false;
			if (aIndex >= 0) {
				sum += Integer.parseInt(a.charAt(aIndex) + "");
				aIndex--;
			}
			if (bIndex >= 0) {
				sum += Integer.parseInt(b.charAt(bIndex) + "");
				bIndex--;
			}

			if (sum > 2) {
				hasCarry = true;
				sb = sb.append(1);
			} else if (sum == 2) {
				hasCarry = true;
				sb = sb.append(0);
			} else {
				sb = sb.append(sum);
			}
		}
		if (hasCarry) {
			sb = sb.append(1);
		}
		return sb.reverse().toString();
	}
}
