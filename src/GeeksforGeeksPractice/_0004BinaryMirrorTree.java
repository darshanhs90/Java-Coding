package GeeksforGeeksPractice;

public class _0004BinaryMirrorTree {
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(4);
		tn.left.left=new TreeNode(5);
		tn.left.left.left=new TreeNode(6);
		tn.left.left.left.left=new TreeNode(7);
		preOrder(tn);System.out.println();
		mirrorTree(tn);
		preOrder(tn);System.out.println();
		//1/2/5/6/7/4/3/
		//1/3/2/4/5/6/7/
	}
	
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			System.out.print(tn.val+"/");
			preOrder(tn.left);
			preOrder(tn.right);
		}
	}

	private static void mirrorTree(TreeNode tn) {
		
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	
}
