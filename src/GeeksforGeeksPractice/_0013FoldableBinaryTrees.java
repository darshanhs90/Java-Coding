package GeeksforGeeksPractice;

public class _0013FoldableBinaryTrees {
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
		//tn.left.right=new TreeNode(5);
		//tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(30);
		System.out.println(isFoldable(tn));
	}
	private static boolean isFoldable(TreeNode tn) {
		if(tn!=null)
		{
			mirror(tn.left);
			if(isStructureSame(tn.left,tn.right))
			{
				mirror(tn.left);
				return true;
			}
			
		}
		return false;
	}
	private static boolean isStructureSame(TreeNode left, TreeNode right) {
		if(left==null && right==null)
		{
			return true;
		}
		else if(left==null||right==null)
		{
			return false;
		}
		else{
			return isStructureSame(left.left, right.left) && isStructureSame(left.right, right.right);
		}
	}
	private static void mirror(TreeNode tn) {
		if(tn!=null)
		{
			mirror(tn.left);
			mirror(tn.right);
			TreeNode temp=tn.left;
			tn.left=tn.right;
			tn.right=temp;
		}
		
	}	
}
