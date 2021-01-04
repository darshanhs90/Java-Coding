package Dec2020Leetcode;

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
		List<Integer> innerList;
		List<NestedInteger> nestedListMain;

		public NestedIterator(List<NestedInteger> nestedList) {
			if (nestedList == null || nestedList.size() == 0)
				return;
			this.nestedListMain = nestedList;
			innerList = getList(this.nestedListMain.get(outerIndex));
			outerIndex++;
		}

		@Override
		public Integer next() {
			if (innerList.size() > 0) {
				int result = innerList.get(0);
				innerList.remove(0);
				if (innerList.size() == 0 && outerIndex < this.nestedListMain.size()) {
					innerList = getList(this.nestedListMain.get(outerIndex));
					outerIndex++;
				}
				return result;
			}
			return -1;
		}

		public List<Integer> getList(NestedInteger nestedInteger) {
			List<Integer> output = new ArrayList<Integer>();
			if (nestedInteger.isInteger()) {
				output.add(nestedInteger.getInteger());
				return output;
			} else {
				List<NestedInteger> list = nestedInteger.getList();
				for (NestedInteger ni : list) {
					output.addAll(getList(ni));
				}
				return output;
			}
		}

		@Override
		public boolean hasNext() {
			return innerList.size() > 0;
		}
	}
}
