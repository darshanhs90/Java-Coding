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

		int outerIndex;
		List<Integer> list;
		List<NestedInteger> nestedList;

		public NestedIterator(List<NestedInteger> nestedList) {
			list = new ArrayList<Integer>();
			this.nestedList = nestedList;
			outerIndex = 0;
			populateList();
		}

		public void populateList() {
			if (outerIndex == nestedList.size())
				return;
			populateList(nestedList.get(outerIndex));
			outerIndex++;
			if (list.size() == 0) {
				populateList();
			}
		}

		public void populateList(NestedInteger ni) {
			if (ni.isInteger()) {
				list.add(ni.getInteger());
			} else {
				List<NestedInteger> nis = ni.getList();
				for (NestedInteger nii : nis) {
					populateList(nii);
				}
			}
		}

		@Override
		public Integer next() {
			int nextVal = list.get(0);
			list.remove(0);
			if (list.size() == 0)
				populateList();
			return nextVal;
		}

		@Override
		public boolean hasNext() {
			return list.size() != 0;
		}
	}
}
