package Jan2021Leetcode;

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
		int outerIndex;
		int innerIndex;

		Integer next;
		int[][] arr;

		public Vector2D(int[][] v) {
			this.arr = v;
			this.outerIndex = 0;
			this.innerIndex = 0;
			this.populateNextValue();
		}

		public int next() {
			int currNext = next;
			populateNextValue();
			return currNext;
		}

		public void populateNextValue() {
			if (innerIndex == arr[outerIndex].length || arr[outerIndex].length == 0) {
				innerIndex = 0;
				outerIndex++;

				if (outerIndex >= arr.length) {
					next = null;
					return;
				}

				if (arr[outerIndex].length == 0) {
					populateNextValue();
					return;
				}

				next = arr[outerIndex][innerIndex];
				innerIndex++;
			} else {
				next = arr[outerIndex][innerIndex];
				innerIndex++;
			}
		}

		public boolean hasNext() {
			return next != null;
		}
	}

}
