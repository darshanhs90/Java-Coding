package GeeksforGeeksPractice;

public class _0027DifferenceBetwenSumsOfEvenOddLevel {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
		public static void main(String args[]){
			TreeNode tn=new TreeNode(5);
			tn.left=new TreeNode(2);
			tn.right=new TreeNode(6);
			tn.left.left=new TreeNode(1);
			tn.left.right=new TreeNode(4);
			tn.left.right.left=new TreeNode(3);
			tn.right.right=new TreeNode(8);
			tn.right.right.right=new TreeNode(9);
			tn.right.right.left=new TreeNode(7);
			System.out.println(findDifference(tn));
		}
	static int oddSum=0,evenSum=0;
	private static int findDifference(TreeNode tn) {
		int height=getHeight(tn);
		for (int i = 1; i <=height; i++) {
			if(i%2==0)
			{
				getSum(tn,i,true);
			}
			else{
				getSum(tn,i,false);
			}
		}
		return oddSum-evenSum;

	}
	private static int getHeight(TreeNode tn) {
		if(tn!=null)
		{
			int leftHeight=0,rightHeight=0;
			if(tn.left!=null)
				leftHeight=getHeight(tn.left);
			if(tn.right!=null)
				rightHeight=getHeight(tn.right);
			return Math.max(leftHeight, rightHeight)+1;
		}
		return 0;
	}
	private static void getSum(TreeNode tn, int level, boolean b) {
		if(tn==null)
			return;
		else{
			if(level==1){
				if(b)
					evenSum+=tn.val;
				else
					oddSum+=tn.val;
			}
			getSum(tn.left, level-1, b);
			getSum(tn.right, level-1, b);
		}

	}



}
