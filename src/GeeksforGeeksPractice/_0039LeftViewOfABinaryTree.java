package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/print-left-view-binary-tree/
 */
public class _0039LeftViewOfABinaryTree {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(12);
		tn.left=new TreeNode(10);
		tn.right=new TreeNode(30);
		tn.right.left=new TreeNode(25);
		tn.right.right=new TreeNode(40);
		printLeftView(tn);
	}


	static boolean flag=true;
	private static void printLeftView(TreeNode tn) {
		int height=getHeight(tn);
		for (int i = 0; i <=height; i++) {
			flag=true;
			printNodes(tn,i);
		}
	}



	private static void printNodes(TreeNode tn, int i) {
		if(tn!=null)
		{
			if(i==1 && flag){
				System.out.println(tn.value);
				flag=false;
			}
			printNodes(tn.left,i-1);
			printNodes(tn.right,i-1);
		}
	}



	private static int getHeight(TreeNode tn) {
		return tn!=null?1+Math.max(getHeight(tn.left), getHeight(tn.right)):0;
	}



	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
