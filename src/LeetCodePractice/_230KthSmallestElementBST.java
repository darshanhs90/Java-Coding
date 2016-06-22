package LeetCodePractice;

public class _230KthSmallestElementBST{
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static int counter=0;
	static int output=0;
	public int kthSmallest(TreeNode root, int k) {
		counter=0;
		preOrder(root,k);
		return output;
	}
	private void preOrder(TreeNode root,int k) {
		if(root!=null&& counter<=k)
		{
			preOrder(root.left,k);

			if(counter==k){
				counter++;
				output=root.val;
				return;
			}
			counter++;
			preOrder(root.right, k);
		}
	}


}

