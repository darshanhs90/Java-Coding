package April2021Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0767ReorganizeString {

	public static void main(String[] args) {
		System.out.println(reorganizeString("aab"));
		System.out.println(reorganizeString("aaab"));
	}

	public static String reorganizeString(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}

		StringBuilder sb = new StringBuilder();
		boolean singleElementFound = false;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {

		}
	}
}
