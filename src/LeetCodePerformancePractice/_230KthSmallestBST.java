package LeetCodePerformancePractice;

public class _230KthSmallestBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static int count=1,element=0;
	public int kthSmallest(TreeNode root, int k) {
		count=1;
		preOrder(root,k);
		return element;
	}
	private void preOrder(TreeNode root,int k) {
		if(root==null||count>k)
			return;
		preOrder(root.left, k);
		if(count==k)
		{
			element=root.val;
			count++;
			return;
		}
		count++;
		preOrder(root.right,k);
	}
}
