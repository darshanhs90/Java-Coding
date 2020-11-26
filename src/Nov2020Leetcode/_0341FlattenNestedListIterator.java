package Nov2020Leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class _0341FlattenNestedListIterator {

	public static void main(String[] args) {

	}

	static public interface NestedInteger {

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
		Stack<NestedInteger> stack;

		public NestedIterator(List<NestedInteger> nestedList) {
			stack = new Stack<NestedInteger>();
			updateStack(nestedList);
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				return null;
			}
			return stack.pop().getInteger();
		}

		@Override
		public boolean hasNext() {
			while (!stack.isEmpty() && !stack.peek().isInteger()) {
				List<NestedInteger> list = stack.pop().getList();
				updateStack(list);
			}
			return !stack.isEmpty();
		}

		public void updateStack(List<NestedInteger> nestedList) {
			for (int i = nestedList.size() - 1; i >= 0; i--) {
				stack.push(nestedList.get(i));
			}
		}
	}

}
