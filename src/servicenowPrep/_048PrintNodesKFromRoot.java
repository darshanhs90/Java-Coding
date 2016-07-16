package servicenowPrep;
public class _048PrintNodesKFromRoot
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(7);
		tn.right=new TreeNode(15);
		tn.left.left=new TreeNode(9);
		//tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(11);
		printNodes(tn,3,1);
	}

	private static void printNodes(TreeNode tn, int k, int currLevel) {
		if(tn==null)return;
		if(k==currLevel)
		{
			System.out.println(tn.value);
			return;
		}
		printNodes(tn.left, k, currLevel+1);
		printNodes(tn.right, k, currLevel+1);
	}

	
	


}