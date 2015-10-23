package GeeksforGeeksPractice;

public class _0014PrintNodesAtKDistance {
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
		printAtDistance(tn,3);
	}
	public static void printAtDistance(TreeNode tn, int level) {
		if(tn!=null)
		{
			if(level==1)
				System.out.println(tn.val);
			else{
				printAtDistance(tn.left,level-1);
				printAtDistance(tn.right,level-1);
			}			
		}
	}

}
