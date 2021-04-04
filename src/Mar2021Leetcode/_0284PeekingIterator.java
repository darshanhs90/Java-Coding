package Mar2021Leetcode;

import java.util.Iterator;

public class _0284PeekingIterator {

	public static void main(String[] args) {
	}

	static class PeekingIterator implements Iterator<Integer> {
		Integer next;
		Iterator<Integer> iter;

		public PeekingIterator(Iterator<Integer> iterator) {
			this.iter = iterator;
			if (iter.hasNext()) {
				next = iter.next();
			}
		}

		// Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
			return next;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
			Integer nextVal = next;
			if (iter.hasNext())
				next = iter.next();
			else {
				next = null;
			}
			return nextVal;
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}
	}

}
