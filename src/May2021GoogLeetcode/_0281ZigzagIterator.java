package May2021GoogLeetcode;

import java.util.Iterator;
import java.util.List;

public class _0281ZigzagIterator {

	public static void main(String[] args) {
	}

	public static class ZigzagIterator {
		Iterator<Integer> iter1;
		Iterator<Integer> iter2;
		boolean turn;

		public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
			iter1 = v1.iterator();
			iter2 = v2.iterator();
			turn = true;
		}

		public int next() {
			int val = 0;
			if (turn) {
				if (iter1.hasNext()) {
					val = iter1.next();
				} else {
					val = iter2.next();
				}
			} else {
				if (iter2.hasNext()) {
					val = iter2.next();
				} else {
					val = iter1.next();
				}
			}

			turn = !turn;
			return val;
		}

		public boolean hasNext() {
			return iter1.hasNext() || iter2.hasNext();
		}
	}

}
