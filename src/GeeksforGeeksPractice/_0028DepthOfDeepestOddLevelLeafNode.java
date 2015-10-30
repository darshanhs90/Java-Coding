package GeeksforGeeksPractice;

public class _0028DepthOfDeepestOddLevelLeafNode {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.right.left=new TreeNode(5);
		tn.right.left.right=new TreeNode(7);
		tn.right.left.right.left=new TreeNode(9);
		tn.right.right=new TreeNode(6);
		tn.right.right.right=new TreeNode(8);
		tn.right.right.right.right=new TreeNode(10);
		tn.right.right.right.right.left=new TreeNode(11);
		findDepthOfDeepestOddLevelLeaf(tn);
	}
	private static void findDepthOfDeepestOddLevelLeaf(TreeNode tn) {
		int height=getHeight(tn);
		for (int i = 1; i <=height; i++) {
			if(i%2!=0)
			{
				printNodes(tn,i);
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
			return Math.max(leftHeight, rightHeight)+1;
		}
		return 0;
	}
	private static void printNodes(TreeNode tn, int level) {
		if(tn!=null)
		{
			if(level==1 && tn.left==null && tn.right==null)
				System.out.println(tn.val);
			printNodes(tn.left, level-1);
			printNodes(tn.right, level-1);
			
		}
		
	}
	
	


}
