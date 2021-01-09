package Dec2020Leetcode;

public class _0788RotatedDigits {
	public static void main(String[] args) {
		System.out.println(rotatedDigits(10));
	}

	public static int rotatedDigits(int N) {
		int count = 0;
		for (int i = 1; i < N; i++) {
			if (sameNumber(i))
				count++;
		}
		return count;
	}

	public static boolean sameNumber(int N) {
		String str = String.valueOf(N);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '1' || c == '0' || c == '8') {
				sb.append(c);
			} else if (c == '2') {
				sb.append('5');
			} else if (c == '5') {
				sb.append('2');
			} else if (c == '6') {
				sb.append('9');
			} else if (c == '9') {
				sb.append('6');
			} else {
				return false;
			}
		}
		return Integer.parseInt(sb.toString()) != N;
	}

}
