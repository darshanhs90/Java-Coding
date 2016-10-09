package PracticeLeetCode;

public class _129SumRootToLeafNumbers {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
	static int sum=0;
	public int sumNumbers(TreeNode root) {
		sum=0;
		findLeafNodes("",root);
		return sum;
	}
	private void findLeafNodes(String string, TreeNode root) {
		if(root==null)
			return;
		if(root.left==null && root.right==null)
		{
			string+=root.val;
			sum+=Integer.parseInt(string);
		}
		findLeafNodes(string+root.val,root.left);
		findLeafNodes(string+root.val,root.right);		
	}
}
