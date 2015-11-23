package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/check-leaves-level/
 */
public class _0038LeavesAtSameLevel {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(12);
		tn.left=new TreeNode(5);
		tn.left.left=new TreeNode(3);
		tn.right=new TreeNode(7);
		tn.right.right=new TreeNode(1);
		System.out.println(checkLevels(tn));
		TreeNode tn1=new TreeNode(12);
		tn1.left=new TreeNode(5);
		tn1.left.left=new TreeNode(3);
		tn1.right=new TreeNode(7);
		System.out.println(checkLevels(tn1));
		TreeNode tn2=new TreeNode(12);
		tn2.left=new TreeNode(5);
		tn2.left.left=new TreeNode(3);
		tn2.left.left.left=new TreeNode(1);
		tn2.left.right=new TreeNode(9);
		tn2.left.right.left=new TreeNode(2);
		System.out.println(checkLevels(tn2));

	}


	static int height=-1;
	static boolean flag=true;
	private static boolean checkLevels(TreeNode tn) {
		height=-1;
		flag=true;
		for (int i = 0; i <=getHeight(tn); i++) {
			getLevel(tn,i,i);
			if(!flag)
				return false;
		}
		return true;
	}



	private static void getLevel(TreeNode tn, int currLevel,int level) {
		if(tn!=null)
		{
			if(currLevel==1 && tn.left==null && tn.right==null)
			{
				if(height==-1)
					height=level;
				else if(height!=level)
				{
					flag=false;
				}
			}
			getLevel(tn.left, currLevel-1, level);
			getLevel(tn.right, currLevel-1, level);
		}
	}



	private static int getHeight(TreeNode tn) {
		if(tn!=null)
		{
			return 1+Math.max(getHeight(tn.left), getHeight(tn.right));
		}
		return 0;
	}



	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
