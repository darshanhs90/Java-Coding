package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.List;

public class _0096UniqueBinarySearchTrees {
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
		tn.right = new TreeNode(2);
		tn.right.left = new TreeNode(3);
		System.out.println(inorderTraversal(tn));
	}

    public List<TreeNode> generateTrees(int n) {
        
    }
}
