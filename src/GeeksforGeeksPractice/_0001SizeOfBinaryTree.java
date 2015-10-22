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
		System.out.println(findSize(tn));
	}


	public static int findSize(TreeNode tn){

		if(tn!=null)
		{
			int leftHeight=0,rightHeight=0;
			if(tn.left!=null)
				leftHeight=findSize(tn.left);
			if(tn.right!=null)
				rightHeight=findSize(tn.right);
			return 1+Math.max(leftHeight,rightHeight);
		}
		return 0;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
