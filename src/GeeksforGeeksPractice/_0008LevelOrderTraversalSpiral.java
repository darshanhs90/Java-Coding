package GeeksforGeeksPractice;

public class _0008LevelOrderTraversalSpiral {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(7);
		tn.left.right=new TreeNode(6);
		tn.right.left=new TreeNode(5);
		tn.right.right=new TreeNode(4);
		levelOrderTraversalSpiral(tn);
	}
	
	public static void levelOrderTraversalSpiral(TreeNode tn)
	{
		if(tn!=null)
		{	
			int height=getHeight(tn);
			boolean spiralFlag=false;
			for (int i = 1; i <=height; i++) {
				if(i%2==0)
					levelOrderTraversal(tn,i,!spiralFlag);
				else
					levelOrderTraversal(tn,i,spiralFlag);
				System.out.println();
			}
		}		
	}

	private static void levelOrderTraversal(TreeNode tn, int level, boolean b) {
		if(tn!=null)
		{
			if(level==1)
				System.out.print(tn.val+"/");
			else{
				if(b)
				{
					levelOrderTraversal(tn.left, level-1, b);
					levelOrderTraversal(tn.right, level-1, b);
				}
				else{
					levelOrderTraversal(tn.right, level-1, b);
					levelOrderTraversal(tn.left, level-1, b);
				}
			}
		}
		
	}

	private static int getHeight(TreeNode tn) {
		if(tn!=null)
		{
			int leftHeight=0,rightHeight=0;
			if(tn.left!=null)
				leftHeight=getHeight(tn.left);
			if(tn.right!=null)
				rightHeight=getHeight(tn.right);
			return 1+Math.max(leftHeight, rightHeight);			
		}
		return 0;
	}
}
