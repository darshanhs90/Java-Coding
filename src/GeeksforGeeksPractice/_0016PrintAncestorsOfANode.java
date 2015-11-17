package GeeksforGeeksPractice;

public class _0016PrintAncestorsOfANode {
	static int[] path;
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		path=new int[1000];
		TreeNode tn=new TreeNode(50);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(30);
		getAncestorsOfANode(tn,path,0,30);
	}
	public static void getAncestorsOfANode(TreeNode tn,int[] path,int pathLen,int val) {
		
	}

}
