package GeeksforGeeksPractice;

public class _0015GetLevelOfANode {
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
		getLevelOfANode(tn,30,0);
	}
	public static void getLevelOfANode(TreeNode tn,int val, int level) {
		if(tn!=null)
		{
			if(tn.val==val)
				System.out.println(level);
			else{
				getLevelOfANode(tn.left, val, level+1);
				getLevelOfANode(tn.right, val, level+1);

			}
		}
	}

}
