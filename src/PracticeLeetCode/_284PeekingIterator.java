package PracticeLeetCode;

import java.util.Iterator;

public class _284PeekingIterator {
	Iterator<Integer> itr;
	Integer next=null;
	public _284PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		itr=iterator;
		if(itr.hasNext())
			next=itr.next();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
		int temp=next;
		if(itr.hasNext())
			next=itr.next();
		else
			next=null;
		return temp;
	}

	public boolean hasNext() {
		return next!=null;
	}
}
