package May2021Leetcode;

public class _0606ConstructStringFromBinaryTree {

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
		System.out.println(tree2str(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		System.out.println(tree2str(tn));
	}
	
    public static String tree2str(TreeNode tn) {
    	
    }
	
}
