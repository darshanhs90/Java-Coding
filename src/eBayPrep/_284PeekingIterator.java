package eBayPrep;

import java.util.Iterator;

public class _284PeekingIterator{
	class PeekingIterator implements Iterator<Integer> {
		Iterator<Integer> iter;
		Integer next;
		public PeekingIterator(Iterator<Integer> iterator) {
			// initialize any member here.
			iter=iterator;
			if(iter.hasNext())
			{
				next=iter.next();
			}
		}


		public Integer peek() {
			return next;
		}


		// Override them if needed.
		@Override
		public Integer next() {
			Integer value=next;
			next=iter.hasNext()?iter.next():null;
			return value;
		}

		@Override
		public boolean hasNext() {
			return next!=null;
		}
	}
}

