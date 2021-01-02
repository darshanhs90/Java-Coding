package Dec2020Leetcode;

public class _0251Flatten2DVector {

	public static void main(String[] args) {
		Vector2D iterator = new Vector2D(new int[][] { new int[] { 1, 2 }, new int[] { 3 }, new int[] { 4 } });

		System.out.println(iterator.next()); // return 1
		System.out.println(iterator.next()); // return 2
		System.out.println(iterator.next()); // return 3
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 4
		System.out.println(iterator.hasNext()); // return false
	}

	static class Vector2D {
		int outerIndex;
		int[][] matrix;
		int innerIndex = 0;

		public Vector2D(int[][] v) {
			this.matrix = v;
			this.outerIndex = 0;
			this.innerIndex = 0;
			for (int[] arr : v) {
				if (arr.length == 0) {
					this.outerIndex++;
				} else {
					break;
				}
			}
		}

		public int next() {
			int output = -1;
			if (innerIndex < matrix[outerIndex].length) {
				output = matrix[outerIndex][innerIndex];
				innerIndex++;
			}

			if (innerIndex == matrix[outerIndex].length) {
				innerIndex = 0;
				outerIndex++;
				for (int i = outerIndex; i < matrix.length; i++) {
					if (matrix[i].length == 0) {
						outerIndex++;
					} else {
						break;
					}
				}
			}
			return output;
		}

		public boolean hasNext() {
			return outerIndex < matrix.length;
		}
	}

}
