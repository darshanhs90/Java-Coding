package Leetcode2020Nov;

public class _0038CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(4));
	}

	public static String countAndSay(int n) {
		String out = "1";
		for (int i = 2; i <= n; i++) {
			String intermediateOutput = "";
			Character c = null;
			int count = 0;
			for (int j = 0; j < out.length(); j++) {
				char currChar = out.charAt(j);
				if (c == null) {
					count = 1;
				} else if (c != currChar) {
					intermediateOutput += count + "" + c;
					count = 1;
				} else {
					count++;
				}
				c = currChar;
			}
			intermediateOutput += count + "" + c;
			out = intermediateOutput;
		}
		return out;
	}
}
