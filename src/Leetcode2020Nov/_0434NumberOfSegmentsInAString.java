package Leetcode2020Nov;

public class _0434NumberOfSegmentsInAString {

	public static void main(String[] args) {
		System.out.println(countSegments("Hello, my name is John"));
		System.out.println(countSegments("Hello"));
		System.out.println(countSegments("love live! mu'sic forever"));
		System.out.println(countSegments(""));
		System.out.println(countSegments(", , , ,        a, eaefa"));
	}

	public static int countSegments(String s) {
		int count = 0;
		Character prevChar = null;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ') {
				if (prevChar == null) {
					count++;
				} else if (prevChar == ' ') {
					count++;
				}
			}
			prevChar = c;
		}
		return count;
	}
}
