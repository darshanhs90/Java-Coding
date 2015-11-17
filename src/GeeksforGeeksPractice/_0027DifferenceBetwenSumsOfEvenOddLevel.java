package GeeksforGeeksPractice;

public class _0027DifferenceBetwenSumsOfEvenOddLevel {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
		public static void main(String args[]){
			TreeNode tn=new TreeNode(5);
			tn.left=new TreeNode(2);
			tn.right=new TreeNode(6);
			tn.left.left=new TreeNode(1);
			tn.left.right=new TreeNode(4);
			tn.left.right.left=new TreeNode(3);
			tn.right.right=new TreeNode(8);
			tn.right.right.right=new TreeNode(9);
			tn.right.right.left=new TreeNode(7);
			System.out.println(findDifference(tn));
		}
	
	private static int findDifference(TreeNode tn) {
	return 0;
	}



}
