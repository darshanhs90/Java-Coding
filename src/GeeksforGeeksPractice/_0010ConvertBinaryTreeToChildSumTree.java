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
		preOrder(tn);System.out.println();
	}
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			System.out.print(tn.val+"/");
			preOrder(tn.left);
			preOrder(tn.right);			
		}

	}
	private static void modifyChildSumProperty(TreeNode tn) {
		int leftValue=0,rightValue=0,diff;
		if(tn==null ||( tn.left==null && tn.right==null))
			return;
		else
		{	
			modifyChildSumProperty(tn.left);
			modifyChildSumProperty(tn.right);
			if(tn.left!=null)
				leftValue=tn.left.val;
			if(tn.right!=null)
				rightValue=tn.right.val;
			diff=-tn.val+(leftValue+rightValue);
			if(diff>0)
			{
				tn.val=tn.val+diff;
			}
			if(diff<0)
			{
				incrementValue(tn,-diff);
			}
		}
	}
	private static void incrementValue(TreeNode tn, int i) {
		if(tn.left!=null){
			tn.left.val=tn.left.val+i;	
			incrementValue(tn.left, i);
		}
		else if(tn.right!=null){
			tn.right.val=tn.right.val+i;
			incrementValue(tn.right, i);
		}
	}

}
