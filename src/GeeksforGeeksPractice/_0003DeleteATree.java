package GeeksforGeeksPractice;

public class _0003DeleteATree {
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(4);
		tn.left.left=new TreeNode(5);
		tn.left.left.left=new TreeNode(6);
		tn.left.left.left.left=new TreeNode(7);
		preOrder(tn);System.out.println();
		deleteTree(tn);
		preOrder(tn);System.out.println();	//-1/-1/-1/-1/-1/-1/-1/
	}
	
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			System.out.print(tn.val+"/");
			preOrder(tn.left);
			preOrder(tn.right);
		}
	}

	private static void deleteTree(TreeNode tn) {
		if(tn!=null)
		{
			deleteTree(tn.left);
			deleteTree(tn.right);
			tn.val=-1;
		}
		
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	
}
