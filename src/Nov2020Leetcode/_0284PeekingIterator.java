package Nov2020Leetcode;

import java.util.Iterator;

public class _0284PeekingIterator {

	public static void main(String[] args) {
	}

	static class PeekingIterator implements Iterator<Integer> {
		Iterator<Integer> iter;
		Integer next = null;

		public PeekingIterator(Iterator<Integer> iterator) {
			// initialize any member here.
			iter = iterator;
			next = iter.next();
		}

		// Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
			return next;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
			Integer nextElement = next;
			if (iter.hasNext()) {
				next = iter.next();
				return nextElement;
			}
			next = null;
			return nextElement;
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}
	}

}
