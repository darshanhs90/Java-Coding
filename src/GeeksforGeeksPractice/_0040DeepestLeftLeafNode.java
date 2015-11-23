package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/deepest-left-leaf-node-in-a-binary-tree/
 */
public class _0040DeepestLeftLeafNode {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.right.left=new TreeNode(5);
		tn.right.right=new TreeNode(6);
		tn.right.left.right=new TreeNode(7);
		tn.right.right.right=new TreeNode(8);
		//tn.right.left.right.left=new TreeNode(9);
		tn.right.right.right.right=new TreeNode(10);	
		getDeepestLeftNode(tn);
	}


	static boolean flag=false;
	private static void getDeepestLeftNode(TreeNode tn) {
		int height=getHeight(tn);
		for (int i = height; i >=0; i--) {
			getLeafNode(tn,i,false);
			if(flag)
				break;
		}
	}



	private static void getLeafNode(TreeNode tn, int i,boolean isLeft) {
		if(tn!=null)
		{
			if(i==1 && isLeft && tn.left==null && tn.right==null){
				flag=true;
				System.out.println(tn.value);
			}
			getLeafNode(tn.left, i-1, true);
			getLeafNode(tn.right, i-1, false);
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
