package GeeksforGeeksPractice;

public class _0001SizeOfBinaryTree {
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(4);
		tn.left.left=new TreeNode(5);
		tn.left.left.left=new TreeNode(6);
		tn.left.left.left.left=new TreeNode(7);
		System.out.println(findSize(tn));//should get 5 as output
	}


	public static int findSize(TreeNode tn){
		if(tn==null)
			return 0;
		int leftHeight=findSize(tn.left);
		int rightHeight=findSize(tn.left);
		return 1+Math.max(leftHeight, rightHeight);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
