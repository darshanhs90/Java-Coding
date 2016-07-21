package LeetCodePractice;

public class _222CountCompleteTreeNodes{
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int countNodes(TreeNode root) {
		if(root==null)
			return 0;
		int leftHeight=getLeftHeight(root);
		int rightHeight=getRightHeight(root);

		if(leftHeight==rightHeight)
		{
			return (2<<(leftHeight-1))-1;
		}
		return countNodes(root.left) + countNodes(root.right)+1;

	}

	private int getLeftHeight(TreeNode root) {
		if(root==null)
			return 0;
		int count=0;
		while(root.left!=null)
		{
			count++;
			root=root.left;
		}
		return 1+count;
	}
	private int getRightHeight(TreeNode root) {
		if(root==null)
			return 0;
		int count=0;
		while(root.right!=null)
		{
			count++;
			root=root.right;
		}
		return 1+count;
	}
}

