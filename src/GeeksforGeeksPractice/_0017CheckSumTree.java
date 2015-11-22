package GeeksforGeeksPractice;

public class _0017CheckSumTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(26);
		tn.left=new TreeNode(10);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(6);
		tn.left.right=new TreeNode(4);
		tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(2);
		System.out.println(checkSumTree(tn));
	}
	public static boolean checkSumTree(TreeNode tn) {
		if(tn!=null)
		{	
			if(tn.left==null && tn.right==null)
				return true;
			if (tn.val==(sum(tn.left)+sum(tn.right)) && checkSumTree(tn.left) && checkSumTree(tn.right))
				return true;
			return false;
		}
		return true;
	}
	private static int sum(TreeNode tn) {
		if(tn!=null)
		{
			return tn.val+sum(tn.left)+sum(tn.right);
		}
		return 0;
	}

}
