package Dec2020Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0236LowestCommonAncestorOfABinaryTree {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(5);
		tn.left.left = new TreeNode(6);
		tn.left.right = new TreeNode(2);
		tn.left.right.left = new TreeNode(7);
		tn.left.right.right = new TreeNode(4);

		tn.right = new TreeNode(1);
		tn.right.left = new TreeNode(0);
		tn.right.right = new TreeNode(8);
		System.out.println(lowestCommonAncestor(tn, tn.left, tn.right).val);
		System.out.println(lowestCommonAncestor(tn, tn.left, tn.left.right.right).val);
		System.out.println(lowestCommonAncestor(tn, tn, tn.left).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		else if (p == q)
			return p;

		HashMap<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
		boolean pFound = false, qFound = false;
		Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
		parentMap.put(root, null);
		nodeQ.offer(root);
		while (!nodeQ.isEmpty()) {
			int size = nodeQ.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = nodeQ.poll();
				if (tn == p) {
					pFound = true;
				}

				if (tn == q) {
					qFound = true;
				}

				if (pFound && qFound)
					break;
				if (tn.left != null) {
					parentMap.put(tn.left, tn);
					nodeQ.offer(tn.left);
				}

				if (tn.right != null) {
					parentMap.put(tn.right, tn);
					nodeQ.offer(tn.right);
				}
			}
		}

		HashSet<TreeNode> parents = new HashSet<TreeNode>();

		TreeNode pNode = p;
		while (pNode != null) {
			parents.add(pNode);
			pNode = parentMap.get(pNode);
		}

		TreeNode qNode = q;
		while (qNode != null) {
			if (parents.contains(qNode))
				return qNode;
			qNode = parentMap.get(qNode);
		}
		return null;
	}

}
