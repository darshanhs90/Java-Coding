package GeeksforGeeksPractice;

public class _0017CheckSumTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(1);
		System.out.println(checkSumTree(tn));
	}
	public static boolean checkSumTree(TreeNode tn) {
		if(tn!=null)
		{	
			if(tn.left==null && tn.right==null)
				return true;
			int leftVal=0,rightVal=0;
			if(tn.left!=null)
				leftVal=tn.left.val;
			if(tn.right!=null)
				rightVal=tn.right.val;
			return (tn.val==leftVal+rightVal) && checkSumTree(tn.left) && checkSumTree(tn.right);
		}
		return true;
	}

}
