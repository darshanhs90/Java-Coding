package PracticeLeetCode;

import java.util.Iterator;

public class _284PeekingIterator {
	class PeekingIterator implements Iterator<Integer> {
		Integer next=null;
		Iterator<Integer> itr;
		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
		    itr=iterator;
		    if(itr.hasNext())
		    {
		    	next=itr.next();
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
			int nextVal=next;
		    if(itr.hasNext())
		    {
		    	next=itr.next();
		    }
		    else{
		    	next=null;
		    }
		    return nextVal;
		}

		@Override
		public boolean hasNext() {
		    return next!=null;
		}
	}
}
