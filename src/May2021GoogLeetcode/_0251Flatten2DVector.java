package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

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
		List<Integer> list;
		int outerIndex;
		int[][] v;

		public Vector2D(int[][] v) {
			this.v = v;
			this.outerIndex = 0;
			this.list = new ArrayList<Integer>();
			populateList();
		}

		public void populateList() {
			if (outerIndex == v.length)
				return;
			populate(outerIndex++);
			if (!hasNext())
				populateList();
		}

		public void populate(int index) {
			for (int i = 0; i < v[index].length; i++) {
				list.add(v[index][i]);
			}
		}

		public int next() {
			int val = list.remove(0);
			if (list.size() == 0) {
				populateList();
			}
			return val;
		}

		public boolean hasNext() {
			return list.size() != 0;
		}
	}

}
