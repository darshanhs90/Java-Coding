package Nov2020_FBPrep;

import java.util.HashMap;

public class _003RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
	}

	static public int romanToInt(String s) {
		int value = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		for (int i = 0; i < s.length(); i++) {
			Character currChar = s.charAt(i);
			Character prevChar = i - 1 > -1 ? s.charAt(i - 1) : null;
			value += map.get(currChar);
			if (prevChar != null)
				if (currChar == 'V' && prevChar == 'I') {
					value -= map.get(prevChar);
					value -= map.get(prevChar);
				} else if (currChar == 'X' && prevChar == 'I') {
					value -= map.get(prevChar);
					value -= map.get(prevChar);
				} else if (currChar == 'L' && prevChar == 'X') {
					value -= map.get(prevChar);
					value -= map.get(prevChar);
				} else if (currChar == 'C' && prevChar == 'X') {
					value -= map.get(prevChar);
					value -= map.get(prevChar);
				} else if (currChar == 'D' && prevChar == 'C') {
					value -= map.get(prevChar);
					value -= map.get(prevChar);
				} else if (currChar == 'M' && prevChar == 'C') {
					value -= map.get(prevChar);
					value -= map.get(prevChar);
				}
		}
		return value;
	}
}
