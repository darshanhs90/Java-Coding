package GeeksforGeeksPractice;

public class _0026ReverseLevelOrderTraversal {
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
		tn.left.right=new TreeNode(5);
		reverseLevelOrderTraversal(tn);
	}
	private static void reverseLevelOrderTraversal(TreeNode tn) {
		int height=getHeight(tn);
		for (int i = height; i >=0; i--) {
			printNodes(tn,i);
		}
	}
	private static void printNodes(TreeNode tn, int i) {
		if(tn!=null)
		{
			if(i==1)
			{
				System.out.println(tn.val);
			}
			printNodes(tn.left, i-1);
			printNodes(tn.right, i-1);
		}

	}
	private static int getHeight(TreeNode tn) {
		if(tn!=null)
		{
			return 1+Math.max(getHeight(tn.left), getHeight(tn.right));

		}
		return 0;
	}



}
