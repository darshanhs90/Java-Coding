package PracticeLeetCode;

public class _270ClosestBSTValue {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static int value;
	static int min=Integer.MAX_VALUE;
	public int closestValue(TreeNode root, double target) {
		if(root==null)
			return -1;
		getCloserValue(root,target);
		return value;
	}
	private void getCloserValue(TreeNode root, double target) {
		if(root==null)
			return;
		int diff=(int) Math.abs(root.val-target);
		if(diff<min)
		{
			min=diff;
			value=root.val;
		}
		if(target>root.val)
			getCloserValue(root.right, target);
		else
			getCloserValue(root.left, target);
	}
}
