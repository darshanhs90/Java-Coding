package Nov2020Leetcode;

public class _0832FlippingAnImage {
	public static void main(String[] args) {
		System.out.println(flipAndInvertImage(
				new int[][] { new int[] { 1, 1, 0 }, new int[] { 1, 0, 1 }, new int[] { 0, 0, 0 } }));
		System.out.println(flipAndInvertImage(new int[][] { new int[] { 1, 1, 0, 0 }, new int[] { 1, 0, 0, 1 },
				new int[] { 0, 1, 1, 1 }, new int[] { 1, 0, 1, 0 } }));
	}

	public static int[][] flipAndInvertImage(int[][] A) {

		for (int i = 0; i < A.length; i++) {
			int leftIndex = 0;
			int rightIndex = A[0].length - 1;
			while (leftIndex <= rightIndex) {
				int temp = A[i][leftIndex];
				A[i][leftIndex] = A[i][rightIndex] == 0 ? 1 : 0;
				A[i][rightIndex] = temp == 0 ? 1 : 0;
				leftIndex++;
				rightIndex--;
			}
		}
		return A;
	}
}
