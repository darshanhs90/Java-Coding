package GeeksforGeeksPractice;

public class _0008LevelOrderTraversalSpiral {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(7);
		tn.left.right=new TreeNode(6);
		tn.right.left=new TreeNode(5);
		tn.right.right=new TreeNode(4);
		levelOrderTraversalSpiral(tn);
		//1/
		//2/3/
		//4/5/6/7/
	}
	
	public static void levelOrderTraversalSpiral(TreeNode tn)
	{
		int height=getHeight(tn);
		boolean flag=false;
		for (int i = 1; i <=height; i++) {
			if(flag)
				getNodes(tn,flag,i);
			else
				getNodes(tn,flag,i);
			flag=!flag;		
			System.out.println();
		}
	}

	private static void getNodes(TreeNode tn, boolean flag, int i) {
		if(tn!=null)
		{
			if(i==1){
				System.out.print(tn.val+"/");
			}
			if(flag)
			{
				getNodes(tn.left, flag, i-1);
				getNodes(tn.right, flag, i-1);
			}
			else{
				getNodes(tn.right, flag, i-1);
				getNodes(tn.left, flag, i-1);
			}
		}
		
	}

	private static int getHeight(TreeNode tn) {
		if(tn!=null)
		{
			return 1+Math.max(getHeight(tn.left),getHeight(tn.right));
		}
		return 0;
	}
}
