package Jan2021Leetcode;

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
		List<Integer> nextValues;
		int outerIndex = 0;
		List<NestedInteger> nestedList;

		public NestedIterator(List<NestedInteger> nestedList) {
			nextValues = new ArrayList<Integer>();
			this.nestedList = nestedList;
			if (nestedList.size() == 0)
				return;
			populateNextList();
		}

		@Override
		public Integer next() {
			int value = nextValues.get(0);
			nextValues.remove(0);
			populateNextList();
			return value;
		}

		public void populateNextList() {
			while (nextValues.isEmpty() && outerIndex < nestedList.size()) {
				getList(nestedList.get(outerIndex), nextValues);
				outerIndex++;
			}
		}

		public void getList(NestedInteger nestedInteger, List<Integer> list) {
			if (nestedInteger.isInteger()) {
				list.add(nestedInteger.getInteger());
			} else {
				List<NestedInteger> ln = nestedInteger.getList();
				for (int i = 0; i < ln.size(); i++) {
					getList(ln.get(i), list);
				}
			}
		}

		@Override
		public boolean hasNext() {
			return !nextValues.isEmpty();
		}
	}
}
