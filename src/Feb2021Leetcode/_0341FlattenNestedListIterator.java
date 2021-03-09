package Feb2021Leetcode;

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
		int outerIndex;;
		List<Integer> innerList;

		public NestedIterator(List<NestedInteger> nestedList) {
			innerList = new ArrayList<Integer>();
			if (nestedList == null || nestedList.size() == 0)
				return;
			this.nestedList = nestedList;
			outerIndex = 0;
			populateInnerList();
		}

		public void populateInnerList() {
			if (outerIndex >= nestedList.size())
				return;
			NestedInteger ni = nestedList.get(outerIndex);
			if (!ni.isInteger() && ni.getList().size() == 0) {
				outerIndex++;
				populateInnerList();
			} else {
				populateInnerListHelper(ni);
				outerIndex++;
				if (innerList.size() == 0)
					populateInnerList();
			}
		}

		public void populateInnerListHelper(NestedInteger ni) {
			if (ni.isInteger()) {
				innerList.add(ni.getInteger());
			} else {
				List<NestedInteger> list = ni.getList();
				for (NestedInteger niChild : list) {
					populateInnerListHelper(niChild);
				}
			}
		}

		@Override
		public Integer next() {
			int val = innerList.get(0);
			innerList.remove(0);

			if (innerList.size() == 0 && outerIndex < nestedList.size()) {
				populateInnerList();
			}
			return val;
		}

		@Override
		public boolean hasNext() {
			return innerList.size() != 0;
		}
	}
}
