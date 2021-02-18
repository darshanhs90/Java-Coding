package Jan2021Leetcode;

import java.util.Iterator;

public class _0284PeekingIterator {

	public static void main(String[] args) {
	}

	static class PeekingIterator implements Iterator<Integer> {
		Iterator<Integer> iterator;
		Integer next;

		public PeekingIterator(Iterator<Integer> iterator) {
			this.iterator = iterator;
			if (this.iterator.hasNext())
				next = this.iterator.next();
		}

		// Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
			return next;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
			Integer nextVal = iterator.hasNext() ? iterator.next() : null;
			Integer retVal = next;
			next = nextVal;
			return retVal;
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}
	}

}
