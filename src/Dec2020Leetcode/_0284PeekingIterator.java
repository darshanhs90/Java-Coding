package Dec2020Leetcode;

import java.util.Iterator;

public class _0284PeekingIterator {

	public static void main(String[] args) {
	}

	static class PeekingIterator implements Iterator<Integer> {
		Iterator<Integer> iter;
		Integer next;

		public PeekingIterator(Iterator<Integer> iterator) {
			// initialize any member here.
			this.iter = iterator;
			if (iter.hasNext())
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
			Integer output = next;
			next = iter.hasNext() ? iter.next() : null;
			return output;
		}

		@Override
		public boolean hasNext() {
			return iter.hasNext() || next != null;
		}
	}

}
