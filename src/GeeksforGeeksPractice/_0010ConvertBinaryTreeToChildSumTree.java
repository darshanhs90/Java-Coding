package GeeksforGeeksPractice;

public class _0010ConvertBinaryTreeToChildSumTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(50);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(30);
		preOrder(tn);System.out.println();
		modifyChildSumProperty(tn);
		preOrder(tn);
		System.out.println();
		//50/8/3/5/2/1/30/
		//50/19/14/5/31/1/30/

	}
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			System.out.print(tn.val+"/");
			preOrder(tn.left);
			preOrder(tn.right);			
		}

	}
	private static void modifyChildSumProperty(TreeNode tn) 
	{
		if(tn!=null)
		{
			modifyChildSumProperty(tn.left);
			modifyChildSumProperty(tn.right);
			int leftVal=0,rightVal=0;
			if(tn.left!=null)
				leftVal=tn.left.val;
			if(tn.right!=null)
				rightVal=tn.right.val;
			int diff=leftVal+rightVal-tn.val;
			if(diff>0)
			{
				tn.val=tn.val+diff;
			}
			if(diff<0)
			{
				increment(tn,-diff);
			}
		}

	}
	private static void increment(TreeNode tn, int diff) {
		if(tn.left!=null)
		{
			tn.left.val+=diff;
			increment(tn.left, diff);
		}else if(tn.right!=null)
		{
			tn.right.val+=diff;
			increment(tn.right, diff);
		}
		
	}

}
