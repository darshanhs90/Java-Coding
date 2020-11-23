package Nov2020Leetcode;

import java.util.Stack;

public class _0173BinarySearchTreeIterator {
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

	static class BSTIterator {

		Stack<TreeNode> stack;
		TreeNode current;

		public BSTIterator(TreeNode root) {
			stack = new Stack<TreeNode>();
			current = root;
		}

		/** @return the next smallest number */
		public int next() {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			TreeNode op = stack.pop();
			current = op.right;
			return op.val;
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !stack.isEmpty() || current != null;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(7);
		tn.left = new TreeNode(3);
		tn.right = new TreeNode(15);
		tn.right.left = new TreeNode(9);
		tn.right.right = new TreeNode(20);

		BSTIterator iterator = new BSTIterator(tn);
		System.out.println(iterator.next()); // return 3
		System.out.println(iterator.next()); // return 7
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 9
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 15
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 20
		System.out.println(iterator.hasNext()); // return false
	}

}
