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
	}

	static class Vector2D {
		int outerIndex, innerIndex;
		Integer nextVal;
		int[][] v;

		public Vector2D(int[][] v) {
			outerIndex = 0;
			innerIndex = 0;
			this.v = v;
			populateNextVal();
		}

		public void populateNextVal() {
			if (outerIndex == v.length) {
				nextVal = null;
				return;
			} else {
				if (innerIndex == v[outerIndex].length) {
					outerIndex += 1;
					innerIndex = 0;
					populateNextVal();
					return;
				}
				nextVal = v[outerIndex][innerIndex];
				innerIndex++;
			}
		}

		public int next() {
			int next = nextVal;
			populateNextVal();
			return next;
		}

		public boolean hasNext() {
			return nextVal != null;
		}
	}

}
