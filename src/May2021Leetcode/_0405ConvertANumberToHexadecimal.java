package May2021Leetcode;

public class _0405ConvertANumberToHexadecimal {

	public static void main(String[] args) {
		System.out.println(toHex(26));
		System.out.println(toHex(-1));
	}

	public static String toHex(int num) {
		if (num == 0)
			return "0";
		char[] c = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', };
		StringBuilder sb = new StringBuilder();

		while (num != 0) {
			sb.append(c[num & 15]);
			num >>>= 4;
		}
		return sb.reverse().toString();
	}
}