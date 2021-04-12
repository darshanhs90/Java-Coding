package April2021Leetcode;

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
		List<Integer> list;
		int outerIndex;

		public NestedIterator(List<NestedInteger> nestedList) {
			outerIndex = 0;
			list = new ArrayList<Integer>();
			this.nestedList = nestedList;
			populateList();
		}

		public void populateList() {
			if (this.outerIndex > this.nestedList.size())
				return;
			populateList(this.nestedList.get(outerIndex));
			outerIndex++;

			if (this.list.size() == 0)
				populateList();
		}

		public void populateList(NestedInteger ni) {
			if (ni.isInteger()) {
				this.list.add(ni.getInteger());
			} else {
				List<NestedInteger> childrens = ni.getList();
				for (NestedInteger child : childrens) {
					populateList(child);
				}
			}
		}

		@Override
		public Integer next() {
			int nextVal = this.list.get(0);
			this.list.remove(0);

			if (this.list.size() == 0) {
				populateList();
			}
			return nextVal;
		}

		@Override
		public boolean hasNext() {
			return this.list.size() > 0;
		}
	}
}
