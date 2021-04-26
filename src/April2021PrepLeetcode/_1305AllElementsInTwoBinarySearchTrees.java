package April2021PrepLeetcode;

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

	static class BstIter implements Iterator<TreeNode> {

		Stack<TreeNode> stack;
		TreeNode next;

		public BstIter(TreeNode tn) {
			stack = new Stack<TreeNode>();
			next = null;
			addLeftNodes(tn);
			populateNext();
		}

		public void addLeftNodes(TreeNode tn) {
			while (tn != null) {
				stack.push(tn);
				tn = tn.left;
			}
		}

		public void populateNext() {
			if (!stack.isEmpty()) {
				TreeNode tn = stack.pop();
				next = tn;
				addLeftNodes(tn.right);
			} else {
				next = null;
			}
		}

		public TreeNode peek() {
			// TODO Auto-generated method stub
			return next;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return next != null;
		}

		@Override
		public TreeNode next() {
			// TODO Auto-generated method stub
			TreeNode nextVal = next;
			populateNext();
			return nextVal;
		}

	}

	public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		BstIter iter1 = new BstIter(root1);
		BstIter iter2 = new BstIter(root2);

		List<Integer> list = new ArrayList<Integer>();
		while (iter1.hasNext() || iter2.hasNext()) {
			if (iter1.hasNext() && iter2.hasNext()) {
				if (iter1.peek().val < iter2.peek().val) {
					TreeNode tn = iter1.next();
					list.add(tn.val);
				} else {
					TreeNode tn = iter2.next();
					list.add(tn.val);
				}
			} else if (iter1.hasNext()) {
				TreeNode tn = iter1.next();
				list.add(tn.val);
			} else {
				TreeNode tn = iter2.next();
				list.add(tn.val);
			}
		}
		return list;
	}

}
