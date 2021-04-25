package April2021PrepLeetcode;

import java.util.Iterator;

public class _0284PeekingIterator {

	public static void main(String[] args) {
	}

	static class PeekingIterator implements Iterator<Integer> {
		Iterator<Integer> iter;
		Integer next;

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
			int currVal = next;
			if (iter.hasNext()) {
				next = iter.next();
			} else {
				next = null;
			}
			return currVal;
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}
	}

}
