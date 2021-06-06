package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _0341FlattenNestedListIterator {

	public static void main(String[] args) {

	}

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	public class NestedIterator implements Iterator<Integer> {
		List<NestedInteger> nestedList;
		List<Integer> innerList;
		int outerIndex;

		public NestedIterator(List<NestedInteger> nestedList) {
			this.nestedList = nestedList;
			outerIndex = 0;
			innerList = new ArrayList<Integer>();
			populateList();
		}

		public void populateList() {
			if (outerIndex >= nestedList.size())
				return;
			populate(nestedList.get(outerIndex));
			outerIndex++;
			if (innerList.size() == 0)
				populateList();
		}

		public void populate(NestedInteger ni) {
			if (ni.isInteger()) {
				innerList.add(ni.getInteger());
			} else {
				List<NestedInteger> niList = ni.getList();
				for (NestedInteger niNew : niList) {
					populate(niNew);
				}
			}
		}

		@Override
		public Integer next() {
			int val = innerList.remove(0);
			if (innerList.size() == 0)
				populateList();
			return val;
		}

		@Override
		public boolean hasNext() {
			return innerList.size() != 0;
		}
	}
}
