package May2021Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class _1305AllElementsInTwoBinarySearchTrees {
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(2);
		tn1.left = new TreeNode(1);
		tn1.right = new TreeNode(4);

		TreeNode tn2 = new TreeNode(1);
		tn2.left = new TreeNode(0);
		tn2.right = new TreeNode(3);

		System.out.println(getAllElements(tn1, tn2));

	}

	static class BstIter implements Iterator<Integer> {
		Integer next;
		Stack<TreeNode> stack;

		public BstIter(TreeNode tn) {
			stack = new Stack<TreeNode>();
			addLeftNode(tn);
			getNextNode();
		}

		public void addLeftNode(TreeNode tn) {
			while (tn != null) {
				stack.push(tn);
				tn = tn.left;
			}
		}

		public void getNextNode() {
			if (!stack.isEmpty()) {
				TreeNode tn = stack.pop();
				next = tn.val;
				if (tn.right != null)
					addLeftNode(tn.right);
			} else {
				next = null;
			}
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public Integer next() {
			Integer nextVal = next;
			getNextNode();
			return nextVal;
		}

		public Integer peek() {
			return next;
		}

	}

	public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		BstIter iter1 = new BstIter(root1);
		BstIter iter2 = new BstIter(root2);

		List<Integer> list = new ArrayList<Integer>();
		while (iter1.hasNext() || iter2.hasNext()) {
			if (iter1.hasNext() && iter2.hasNext()) {
				if (iter1.peek() < iter2.peek()) {
					list.add(iter1.next());
				} else {
					list.add(iter2.next());
				}
			} else if (iter1.hasNext()) {
				list.add(iter1.next());
			} else {
				list.add(iter2.next());
			}
		}
		return list;
	}

}
