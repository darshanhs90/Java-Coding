package servicenowPrep;
public class _041LevelOrderTraversalSpiral
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		levelOrderTraversal(tn);
	}

	private static void levelOrderTraversal(TreeNode tn) {
		int height=getHeight(tn);
		boolean flag=true;
		for (int i = 0; i < height; i++) {
			printNodes(tn,i,flag);
			flag=!flag;
			System.out.println();
		}
	}

	private static void printNodes(TreeNode tn, int i,boolean flag) {
		if(tn==null||i<0)return;
		if(i==0)
			System.out.print(tn.value+"/");
		if(flag){
			printNodes(tn.left, i-1,flag);
			printNodes(tn.right, i-1,flag);
		}
		else{
			printNodes(tn.right, i-1,flag);
			printNodes(tn.left, i-1,flag);
		}
	}

	private static int getHeight(TreeNode tn) {
		if(tn==null)	
			return 0;
		return 1+Math.max(getHeight(tn.left), getHeight(tn.right));
	}



}