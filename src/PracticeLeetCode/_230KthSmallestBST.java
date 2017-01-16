package PracticeLeetCode;

public class _230KthSmallestBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static int count=0;
	static int value=0;
	
    public int kthSmallest(TreeNode root, int k) {
    	count=0;
    	value=0;
        preOrder(root,k);
        return value;
    }

	private void preOrder(TreeNode root, int k) {
		if(root!=null)
		{
			preOrder(root.left, k);
			count++;
			if(count==k)
			{
				value=root.val;
				return;
			}
			preOrder(root.right, k);
		}
	}
}
