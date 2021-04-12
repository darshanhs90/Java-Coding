package April2021Leetcode;

import java.util.List;

public class _0339NestedListWeightSum {

	public static void main(String[] args) {

	}

	abstract public interface NestedInteger {
		// Constructor initializes an empty nested list.
		// public NestedInteger();

		// Constructor initializes a single integer.
		// public NestedInteger(int value);

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value);

		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		public void add(NestedInteger ni);

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return empty list if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	public static int depthSum(List<NestedInteger> nestedList) {
		int sum = 0;
		for (NestedInteger ni : nestedList) {
			if (ni.isInteger()) {
				sum += ni.getInteger();
			} else {
				sum += depthSum(ni, 2);
			}
		}
		return sum;
	}

	public static int depthSum(NestedInteger ni, int level) {
		int sum = 0;
		List<NestedInteger> list = ni.getList();
		for (NestedInteger child : list) {
			if (child.isInteger()) {
				sum += child.getInteger() * level;
			} else {
				sum += depthSum(child, level + 1);
			}
		}
		return sum;
	}

}
