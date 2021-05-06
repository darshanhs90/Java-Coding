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

	static class BSTIter implements Iterator<Integer> {
		Stack<TreeNode> stack;
		Integer next;

		public BSTIter(TreeNode tn) {
			stack = new Stack<TreeNode>();
			if (tn != null) {
				addLeftNodes(tn);
			}

			populateNextVal();
		}

		public void addLeftNodes(TreeNode tn) {
			while (tn != null) {
				stack.push(tn);
				tn = tn.left;
			}
		}

		public void populateNextVal() {
			if (!stack.isEmpty()) {
				TreeNode tn = stack.pop();
				if (tn.right != null) {
					addLeftNodes(tn.right);
				}
				next = tn.val;
			} else {
				next = null;
			}
		}

		public Integer peek() {
			return next;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return next != null;
		}

		@Override
		public Integer next() {
			Integer val = next;
			populateNextVal();
			return val;
		}
	}

	public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> list = new ArrayList<Integer>();
		BSTIter iter1 = new BSTIter(root1);
		BSTIter iter2 = new BSTIter(root1);

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
