package LeetcodeTemplate;

import java.util.ArrayList;
import java.util.List;

public class _0530MinimumAbsoluteDifferenceInBST {
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
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(2);
		System.out.println(getMinimumDifference(tn));
	}

	
}
