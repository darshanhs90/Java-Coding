package May2021GoogLeetcode;

public class _1007MinimumDominoRotationsForEqualRow {
	public static void main(String[] args) {
		System.out.println(minDominoRotations(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 }));
		System.out.println(minDominoRotations(new int[] { 3, 5, 1, 2, 3 }, new int[] { 3, 6, 3, 3, 4 }));
	}

	public static int minDominoRotations(int[] tops, int[] bottoms) {
		int[] countA = new int[7];
		int[] countB = new int[7];
		int[] same = new int[7];

		for (int i = 0; i < tops.length; i++) {
			countA[tops[i]]++;
			countB[bottoms[i]]++;
			if (tops[i] == bottoms[i])
				same[tops[i]]++;
		}

		for (int i = 1; i < 7; i++) {
			if (countA[i] + countB[i] - same[i] == tops.length)
				return tops.length - Math.max(countA[i], countB[i]);
		}
		return -1;
	}
}
