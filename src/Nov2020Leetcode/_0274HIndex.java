package Nov2020Leetcode;

public class _0274HIndex {

	public static void main(String[] args) {
		System.out.println(hIndex(new int[] { 3, 0, 6, 1, 5 }));
	}

	public static int hIndex(int[] citations) {
		int n = citations.length;
		int[] out = new int[n + 1];

		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= n)
				out[n]++;
			else {
				out[citations[i]]++;
			}
		}

		int count = 0;
		for (int i = out.length - 1; i >= 0; i--) {
			count += out[i];
			if (count >= i)
				return i;
		}
		return 0;
	}

}
