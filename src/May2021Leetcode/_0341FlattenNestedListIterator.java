package May2021Leetcode;

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
		List<Integer> list;
		int outerIndex;
		List<NestedInteger> nestedList;

		public NestedIterator(List<NestedInteger> nestedList) {
			list = new ArrayList<Integer>();
			outerIndex = 0;
			this.nestedList = nestedList;
			// populateList();
		}

		public void populateList() {
			if (outerIndex >= nestedList.size())
				return;
			populateList(nestedList.get(outerIndex++));
			if (list.size() == 0)
				populateList();
		}

		public void populateList(NestedInteger ni) {
			if (ni.isInteger()) {
				list.add(ni.getInteger());
			} else {
				List<NestedInteger> lst = ni.getList();
				for (NestedInteger child : lst) {
					populateList(child);
				}
			}
		}

		@Override
		public Integer next() {
			Integer val = list.get(0);
			list.remove(0);

			if (list.size() == 0)
				populateList();
			return val;
		}

		@Override
		public boolean hasNext() {
			return list.size() != 0;
		}
	}
}
