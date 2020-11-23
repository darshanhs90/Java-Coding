package Nov2020Leetcode;

public class _1323Maximum69Number {
	public static void main(String[] args) {
		System.out.println(maximum69Number(9669));
		System.out.println(maximum69Number(9996));
		System.out.println(maximum69Number(9999));
	}

	public static int maximum69Number(int num) {
		int max = num;
		String str = String.valueOf(num);
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i) == '9' ? '6' : '9';
			String newNum = str.substring(0, i) + c + str.substring(i + 1);
			max = Math.max(max, Integer.parseInt(newNum));
		}
		return max;
	}
}
