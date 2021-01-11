package Dec2020Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0993CousinsInBinaryTree {
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
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.left = new TreeNode(4);
		System.out.println(isCousins(tn, 4, 3));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		tn.right.right = new TreeNode(5);
		System.out.println(isCousins(tn, 5, 4));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		System.out.println(isCousins(tn, 2, 3));
	}

	static class Relation {
		TreeNode parent;
		TreeNode curr;
		int level;

		public Relation(TreeNode parent, TreeNode curr, int level) {
			this.parent = parent;
			this.curr = curr;
			this.level = level;
		}
	}

	public static boolean isCousins(TreeNode root, int x, int y) {
		if (root == null)
			return false;
		Queue<Relation> q = new LinkedList<Relation>();
		Relation rx = null, ry = null;
		q.offer(new Relation(null, root, 0));
		while (!q.isEmpty()) {
			int size = q.size();
			if (rx != null && ry != null)
				break;
			for (int i = 0; i < size; i++) {
				Relation r = q.poll();
				if (r.curr.val == x) {
					rx = r;
				} else if (r.curr.val == y) {
					ry = r;
				}

				if (r.curr.left != null) {
					q.offer(new Relation(r.curr, r.curr.left, r.level + 1));
				}

				if (r.curr.right != null) {
					q.offer(new Relation(r.curr, r.curr.right, r.level + 1));
				}
			}
		}

		return rx.parent != ry.parent && rx.level == ry.level;
	}

}
