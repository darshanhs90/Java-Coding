package FacebookPrep;

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
		Integer next;

		public NestedIterator(List<NestedInteger> nestedList) {
			list = new ArrayList<Integer>();
			this.nestedList = nestedList;
			outerIndex = 0;
			populateNextVal();
		}

		public void populateNextVal() {
			if (outerIndex == nestedList.size() && list.size() == 0) {
				next = null;
				return;
			}

			if (list.size() == 0) {
				populateList(nestedList.get(outerIndex));
				outerIndex++;
				if (list.size() == 0)
					populateNextVal();
				else {
					next = list.get(0);
					list.remove(0);
				}
			} else {
				next = list.get(0);
				list.remove(0);
			}
		}

		public void populateList(NestedInteger ni) {
			if (ni.isInteger()) {
				list.add(ni.getInteger());
			} else {
				List<NestedInteger> lst = ni.getList();
				for (NestedInteger nestedInteger : lst) {
					populateList(nestedInteger);
				}
			}
		}

		@Override
		public Integer next() {
			Integer currVal = next;
			populateNextVal();
			return currVal;
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}

	}
}
