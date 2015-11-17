package GeeksforGeeksPractice;

public class _0021ConvertTreeToSumTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(-2);
		tn.right=new TreeNode(6);
		tn.left.left=new TreeNode(8);
		tn.left.right=new TreeNode(-4);
		tn.right.left=new TreeNode(7);
		tn.right.right=new TreeNode(5);
		preOrder(tn);
		System.out.println();
		getSum(tn);
		preOrder(tn);
		//10//-2//8//-4//6//7//5//
		//20//4//0//0//12//0//0//
	}
	private static int getSum(TreeNode tn) {
		
		return 0;
	}
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			System.out.print(tn.val+"//");
			preOrder(tn.left);
			preOrder(tn.right);
		}

	}

}
