package Dec2020Leetcode;

public class _0461HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}

	public static int hammingDistance(int x, int y) {
		String str1 = Integer.toString(x, 2);
		String str2 = Integer.toString(y, 2);
		int count = 0;
		int str1Index = str1.length() - 1;
		int str2Index = str2.length() - 1;
		while (str1Index >= 0 || str2Index >= 0) {
			int val1 = 0, val2 = 0;
			if (str1Index >= 0 && str2Index >= 0) {
				val1 = str1.charAt(str1Index) - '0';
				val2 = str2.charAt(str2Index) - '0';
			} else if (str1Index >= 0) {
				val1 = str1.charAt(str1Index) - '0';
			} else if (str2Index >= 0) {
				val2 = str2.charAt(str2Index) - '0';
			}

			if (val1 != val2)
				count++;
			str1Index--;
			str2Index--;
		}
		return count;
	}
}
