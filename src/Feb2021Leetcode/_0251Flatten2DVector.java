package Feb2021Leetcode;

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

		iterator = new Vector2D(new int[][] { new int[] { 1, }, new int[] {} });

		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 4
		System.out.println(iterator.hasNext()); // return false
	}

	static class Vector2D {
		int outerIndex, innerIndex;
		int[][] arr;
		Integer next;

		public Vector2D(int[][] v) {
			this.arr = v;
			outerIndex = 0;
			innerIndex = 0;
			populateNextVal();
		}

		public void populateNextVal() {
			if (outerIndex >= this.arr.length) {
				next = null;
			} else {
				if (innerIndex >= this.arr[outerIndex].length) {
					outerIndex++;
					innerIndex = 0;
					populateNextVal();
				} else {
					next = this.arr[outerIndex][innerIndex];
					innerIndex++;
				}
			}
		}

		public int next() {
			int nextVal = next;
			populateNextVal();
			return nextVal;
		}

		public boolean hasNext() {
			return next != null;
		}
	}

}
