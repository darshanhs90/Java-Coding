package Feb2021Leetcode;

public class _0358RearrangeStringKDistanceApart {

	public static void main(String[] args) {
		System.out.println(rearrangeString("aabbcc", 3));
		System.out.println(rearrangeString("aaabc", 3));
		System.out.println(rearrangeString("aaadbbcc", 2));
	}

	static class Pair {
		char charVal;
		int count;

		public Pair(char charVal, int count) {
			this.charVal = charVal;
			this.count = count;
		}
	}

	public static String rearrangeString(String s, int k) {
	}

}
