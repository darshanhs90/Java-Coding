package PracticeLeetCode;

public class _230KthSmallestBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static int count=0;
	static int val=0;
    public int kthSmallest(TreeNode root, int k) {
    	count=0;
    	val=0;
        preOrder(root,k);
        return val;
    }
	private void preOrder(TreeNode root,int k) {
		if(root!=null)
		{

			preOrder(root.left,k);
			if(count==k)
			{
				val=root.val;
			}
			count++;
			preOrder(root.right,k);
		}
		
	}
}
