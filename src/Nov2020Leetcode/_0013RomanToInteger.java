package Nov2020Leetcode;

import java.util.HashMap;

public class _0013RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
	}

	public static int romanToInt(String s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("IV", 4);
		map.put("X", 10);
		map.put("IX", 9);
		map.put("L", 50);
		map.put("XL", 40);
		map.put("C", 100);
		map.put("XC", 90);
		map.put("D", 500);
		map.put("CD", 400);
		map.put("M", 1000);
		map.put("CM", 900);

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			String currStr = s.charAt(i) + "";
			String prevStr = ((i - 1) > -1 ? s.charAt(i - 1) + "" : "") + currStr;
			if (prevStr.length() == 2 && map.containsKey(prevStr)) {
				count += map.get(prevStr);
				count -= map.get(s.charAt(i - 1) + "");
			} else {
				count += map.get(currStr);
			}
		}
		return count;
	}
}
