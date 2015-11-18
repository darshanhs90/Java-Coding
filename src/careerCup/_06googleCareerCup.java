package careerCup;

/*
 * Link: http://www.careercup.com/question?id=56692
 * Given a Starting Node and Ending Node in a Graph where each Node has a pointer to its parent and all its children nodes.
 * Find all the leaf nodes between the Starting and Ending Node.
 */
public class _06googleCareerCup {

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(null,1);
		tn.left=new TreeNode(tn,1);
		tn.right=new TreeNode(tn,1);
		tn.left.left=new TreeNode(tn.left,1);
		tn.left.right=new TreeNode(tn.left,1);
		tn.right.left=new TreeNode(tn.right,1);
		tn.right.right=new TreeNode(tn.right,1);
		tn.left.left.left=new TreeNode(tn.left.left,1);
		tn.left.left.right=new TreeNode(tn.left.left,1);
		tn.left.right.left=new TreeNode(tn.left.right,1);
		tn.left.right.right=new TreeNode(tn.left.right,1);
		tn.right.left.left=new TreeNode(tn.right.left,1);
		tn.right.left.right=new TreeNode(tn.right.left,1);
		tn.right.right.left=new TreeNode(tn.right.right,1);
		tn.right.right.right=new TreeNode(tn.right.right,1);
		printBetweenNodes(tn.left.left,tn.right.right);
	}

	private static void printBetweenNodes(TreeNode left, TreeNode right) {
		//get main parent of path and add to hashmap
		//if already present stop and check others added to list and check its leaf nodes
		
		
	}

	public static class TreeNode{
		TreeNode parent,left,right;
		int val;
		public TreeNode(TreeNode parent,int val) {
			this.parent=parent;
			this.val=val;
		}
	}
}
