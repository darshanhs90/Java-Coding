package Dec2020Leetcode;

import java.util.HashMap;

public class _0246StrobogrammaticNumber {

	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("69"));
		System.out.println(isStrobogrammatic("88"));
		System.out.println(isStrobogrammatic("962"));
		System.out.println(isStrobogrammatic("1"));
	}

	public static boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('1', '1');
		map.put('0', '0');
		map.put('6', '9');
		map.put('9', '6');
		map.put('8', '8');
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			if (!map.containsKey(c))
				return false;
			sb.append(map.get(c));
		}
		return num.equals(sb.reverse().toString());
	}
}
