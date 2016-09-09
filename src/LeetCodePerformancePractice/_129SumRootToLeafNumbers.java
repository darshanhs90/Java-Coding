package LeetCodePerformancePractice;

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
		findSum(root,"");
		return sum;
	}
	private void findSum(TreeNode root, String string) {
		if(root==null)
			return;
		if(root.left==null && root.right==null){
			string+=root.val;
			sum+=string.length()>0?Integer.parseInt(string):0;
			return;
		}
		findSum(root.left, string+root.val);
		findSum(root.right, string+root.val);
	}
}
