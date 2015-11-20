package careerCup;

/*
 * Link: http://www.careercup.com/question?id=83696
 * Write code to print out a binary tree so that each depth is printed on its own line.
 * The spacing doesn't need to be correct, but the items within a depth must be in order and on a single line.
 *         1
 *       /   \
 *     2       3
 *            / \
 *           4   5
 *                \ 
 *                 7
 * 1
 * 2 3
 * 4 5
 * 7
 */
public class _16googleCareerCup {

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.right.left=new TreeNode(4);
		tn.right.right=new TreeNode(5);
		tn.right.right.right=new TreeNode(7);
		int height=getHeight(tn);
		for (int i = 0; i <=height; i++) {
			printElements(tn,i);
			System.out.println();
		}
	}
	private static void printElements(TreeNode tn,int i) {
		if(tn!=null)
		{
			if(i==1)
				System.out.print(tn.val);
			printElements(tn.left, i-1);
			printElements(tn.right, i-1);			
		}
	}
	private static int getHeight(TreeNode tn) {
		if(tn!=null)
		{
			return 1+Math.max(getHeight(tn.left),getHeight(tn.right));
		}
		return 0;
	}
	static class TreeNode{
		TreeNode left,right;
		int val;
		public TreeNode(int val) {
			this.val=val;
		}


	}

}
