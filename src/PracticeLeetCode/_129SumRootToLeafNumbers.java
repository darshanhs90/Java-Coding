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
	static int output;
    public int sumNumbers(TreeNode root) {
        output=0;
        findSum("",root);
        return output;
    }
	private void findSum(String string, TreeNode root) {
		if(root==null)
			return;
		if(root.left==null && root.right==null)
		{
			string+=root.val;
			output+=Integer.parseInt(string);
			return;
		}
		findSum(string+root.val, root.left);
		findSum(string+root.val, root.right);
	}
}
