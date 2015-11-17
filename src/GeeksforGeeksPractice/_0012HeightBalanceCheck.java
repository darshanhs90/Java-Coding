package GeeksforGeeksPractice;

public class _0012HeightBalanceCheck {
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
		System.out.println(heightBalanceCheck(tn));
	}
	
	private static boolean heightBalanceCheck(TreeNode tn) {
		
		return false;
	}


}
