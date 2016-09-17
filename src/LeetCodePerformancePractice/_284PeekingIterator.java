package LeetCodePerformancePractice;

import java.util.Iterator;

public class _284PeekingIterator {
	class PeekingIterator implements Iterator<Integer> {
		Integer next=null;
		Iterator<Integer> iterator;
		public PeekingIterator(Iterator<Integer> iterator) {
			this.iterator=iterator;
			if(iterator.hasNext())
			{
				next=iterator.next();
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
			int currElement=next;
			if(iterator.hasNext())
				next=iterator.next();
			else
				next=null;
			return currElement;
		}

		@Override
		public boolean hasNext() {
			return next==null?false:true;
		}
	}
}
