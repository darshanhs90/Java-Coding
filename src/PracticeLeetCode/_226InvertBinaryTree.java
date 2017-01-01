package PracticeLeetCode;

public class _226InvertBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(4);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(7);
		tn.left.left=new TreeNode(1);
		tn.left.right=new TreeNode(3);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(9);
		tn=invertTree(tn);

	}
    public static TreeNode invertTree(TreeNode root) {
        if(root==null)
        	return root;
        invertTree(root.left);
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.right);
        return root;
    }
}
