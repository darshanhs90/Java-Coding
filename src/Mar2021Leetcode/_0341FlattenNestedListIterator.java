package Mar2021Leetcode;

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
		int outerIndex = 0;
		List<NestedInteger> nestedList;
		List<Integer> innerList;

		public NestedIterator(List<NestedInteger> nestedList) {
			this.nestedList = nestedList;
			innerList = new ArrayList<Integer>();
			outerIndex = 0;
			populateList();
		}

		public void populateList() {
			if (outerIndex == nestedList.size())
				return;
			addToList(nestedList.get(outerIndex));
			outerIndex++;
			if (innerList.size() == 0)
				populateList();
		}

		public void addToList(NestedInteger ni) {
			if (ni.isInteger()) {
				innerList.add(ni.getInteger());
			} else {
				List<NestedInteger> list = ni.getList();
				for (NestedInteger nestedInt : list) {
					addToList(nestedInt);
				}
			}
		}

		@Override
		public Integer next() {
			Integer val = innerList.remove(0);
			if (innerList.size() == 0)
				populateList();
			return val;
		}

		@Override
		public boolean hasNext() {
			return !innerList.isEmpty();
		}
	}
}
