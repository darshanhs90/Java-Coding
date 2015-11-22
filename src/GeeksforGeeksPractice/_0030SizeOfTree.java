package GeeksforGeeksPractice;

import GeeksforGeeksPractice._0022VerticalSumInTree.TreeNode;

public class _0030SizeOfTree {

	public static void main(String[] args) {

		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		System.out.println(sizeOfTree(tn));

	}

	private static int sizeOfTree(TreeNode tn) {
		if(tn!=null)
		{
			return 1+sizeOfTree(tn.left)+sizeOfTree(tn.right);
			
		}
		return 0;
	}

	
}
