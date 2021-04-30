package May2021PrepLeetcode;

public class _0013RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
	}

	public static int romanToInt(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length()) {
				String str = s.charAt(i) + "" + s.charAt(i + 1);
				switch (str) {
				case "IV":
					sum += 4;
					i++;
					continue;
				case "IX":
					sum += 9;
					i++;
					continue;
				case "XL":
					sum += 40;
					i++;
					continue;
				case "XC":
					sum += 90;
					i++;
					continue;
				case "CD":
					sum += 400;
					i++;
					continue;
				case "CM":
					sum += 900;
					i++;
					continue;
				}
			}
			char c = s.charAt(i);
			switch (c) {
			case 'I':
				sum += 1;
				break;
			case 'V':
				sum += 5;
				break;
			case 'X':
				sum += 10;
				break;
			case 'L':
				sum += 50;
				break;
			case 'C':
				sum += 100;
				break;
			case 'D':
				sum += 500;
				break;
			case 'M':
				sum += 1000;
				break;
			}
		}
		return sum;
	}
}
