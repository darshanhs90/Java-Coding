package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/given-binary-tree-print-nodes-two-given-level-numbers/ 
 */
public class _0048NodesBetweenLevels {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(20);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(22);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(12);
		tn.left.right.left=new TreeNode(10);
		tn.left.right.right=new TreeNode(14);
		printNodes(tn,2,4);		
	}
	
	private static void printNodes(TreeNode tn,int low, int high) {
		for (int i = low-1; i <=high; i++) {
			findNodes(tn,i);
		}
	}

	private static void findNodes(TreeNode tn, int level) {
		if(tn!=null)
		{
			if(level==0)
			{
				System.out.println(tn.value);
			}
			findNodes(tn.left, level-1);
			findNodes(tn.right, level-1);
		}
	}

	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
