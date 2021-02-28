package FacebookPrep;

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
		Integer nextVal;
		int[][] arr;

		public Vector2D(int[][] v) {
			outerIndex = 0;
			innerIndex = 0;
			nextVal = null;
			this.arr = v;
			populateNextValue();
		}

		public void populateNextValue() {
			if (outerIndex == arr.length) {
				nextVal = null;
				return;
			}
			if (innerIndex == arr[outerIndex].length) {
				outerIndex++;
				innerIndex = 0;
				populateNextValue();
				return;
			}

			nextVal = arr[outerIndex][innerIndex];
			innerIndex++;
		}

		public int next() {
			int currVal = nextVal;
			populateNextValue();
			return currVal;
		}

		public boolean hasNext() {
			return nextVal != null;
		}
	}

}
