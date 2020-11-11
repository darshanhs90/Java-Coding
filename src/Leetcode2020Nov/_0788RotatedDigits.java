package Leetcode2020Nov;

import java.util.HashMap;

public class _0788RotatedDigits {
	public static void main(String[] args) {
		System.out.println(rotatedDigits(10));
	}

	public static int rotatedDigits(int N) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('2', '5');
		map.put('5', '2');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		int count = 0;
		for (int i = 2; i <= N; i++) {
			String str = String.valueOf(i);
			StringBuilder sb = new StringBuilder();
			boolean isValidNumber = true;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (map.containsKey(c)) {
					sb = sb.append(map.get(c));
				} else {
					isValidNumber = false;
					break;
				}
			}

			if (isValidNumber && Integer.parseInt(sb.toString()) != i) {
				count++;
			}
		}
		return count;
	}
}
