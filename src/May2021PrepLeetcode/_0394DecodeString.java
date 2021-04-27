package May2021PrepLeetcode;

import java.util.Stack;

public class _0394DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
		System.out.println(decodeString("abc3[cd]xyz"));
	}

	static class Pair {
		String str;
		int count;
		boolean isString;

		public Pair(String str) {
			this.str = str;
			this.isString = true;
		}

		public Pair(int count) {
			this.count = count;
		}
	}

	public static String decodeString(String s) {
		
	}

}
