package PracticeLeetCode;

import java.util.Iterator;

public class _284PeekingIterator {
	class PeekingIterator implements Iterator<Integer> {
		Iterator<Integer> iterator;
		Integer next;
		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
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
			int temp=next;
		    if(iterator.hasNext())
		    {
		    	next=iterator.next();
		    }
		    else{
		    	next=null;
		    }
		    return temp;
		}

		@Override
		public boolean hasNext() {
		    return next!=null;
		}
	}
}
