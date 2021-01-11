package Dec2020Leetcode;

public class _1323Maximum69Number {
	public static void main(String[] args) {
		System.out.println(maximum69Number(9669));
		System.out.println(maximum69Number(9996));
		System.out.println(maximum69Number(9999));
	}

	public static int maximum69Number(int num) {
		String str = String.valueOf(num);
		char cArr[] = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			char c = cArr[i];
			if (c == '6') {
				cArr[i] = '9';
				return Integer.parseInt(new String(cArr));
			}
		}
		return num;
	}
}
