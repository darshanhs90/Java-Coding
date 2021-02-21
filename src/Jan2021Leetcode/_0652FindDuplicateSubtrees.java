package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0652FindDuplicateSubtrees {
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
		tn.left.left = new TreeNode(4);

		tn.right = new TreeNode(3);
		tn.right.right = new TreeNode(4);

		tn.right.left = new TreeNode(2);
		tn.right.left.left = new TreeNode(4);

		System.out.println(findDuplicateSubtrees(tn));
	}

	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> output = new ArrayList<TreeNode>();
		if (root == null)
			return output;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root.left != null)
			q.offer(root.left);
		if (root.right != null)
			q.offer(root.right);
		HashSet<String> set = new HashSet<String>();
		List<String> list = new ArrayList<String>();
		HashSet<Integer> outSet = new HashSet<Integer>();

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				list = new ArrayList<String>();
				inOrder(tn, list);
				String str = String.join(",", list);
				if (set.contains(str)) {
					if (!outSet.contains(tn.val)) {
						outSet.add(tn.val);
						output.add(tn);
					}
				}
				set.add(str);

				if (tn.left != null)
					q.offer(tn.left);

				if (tn.right != null)
					q.offer(tn.right);
			}
		}
		return output;
	}

	public static void inOrder(TreeNode root, List<String> list) {
		if (root == null) {
			list.add("#");
			return;
		}

		inOrder(root.left, list);
		list.add(String.valueOf(root.val));
		inOrder(root.right, list);
	}

}
