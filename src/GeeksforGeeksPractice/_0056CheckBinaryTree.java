package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/check-whether-binary-tree-full-binary-tree-not/
 */
public class _0056CheckBinaryTree {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		System.out.println(checkBinaryTree(tn));
		
		TreeNode tn1=new TreeNode(1);
		tn1.left=new TreeNode(2);
		tn1.right=new TreeNode(3);
		tn1.left.left=new TreeNode(4);
		System.out.println(checkBinaryTree(tn1));
	}
	
	private static boolean checkBinaryTree(TreeNode tn) {
		if(tn!=null)
		{
			if(tn.left==null && tn.right==null)
				return true;
			if(tn.left==null|| tn.right==null)
				return false;
			return checkBinaryTree(tn.left) && checkBinaryTree(tn.right);
		}
		return false;
	}








	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
