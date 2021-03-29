package Mar2021Leetcode;

public class _0013RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
	}

	public static int romanToInt(String s) {
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			boolean found = true;
			if (i + 1 < s.length()) {
				char c2 = s.charAt(i + 1);
				String combined = c1 + "" + c2;
				i++;
				if (combined.equals("IV")) {
					num += 4;
				} else if (combined.equals("IX")) {
					num += 9;
				} else if (combined.equals("XL")) {
					num += 40;
				} else if (combined.equals("XC")) {
					num += 90;
				} else if (combined.equals("CD")) {
					num += 400;
				} else if (combined.equals("CM")) {
					num += 900;
				} else {
					i--;
					found = false;
				}
			} else {
				found = false;
			}

			if (!found) {
				switch (c1) {
				case 'I':
					num += 1;
					break;
				case 'V':
					num += 5;
					break;
				case 'X':
					num += 10;
					break;
				case 'L':
					num += 50;
					break;
				case 'C':
					num += 100;
					break;
				case 'D':
					num += 500;
					break;
				case 'M':
					num += 1000;
					break;
				default:
					break;

				}
			}
		}
		return num;
	}
}
