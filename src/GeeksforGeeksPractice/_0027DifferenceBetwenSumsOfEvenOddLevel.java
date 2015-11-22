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
	static int evenSum=0,oddSum=0;
	private static int findDifference(TreeNode tn) {
		int height=getHeight(tn);
		for (int i = 0; i <=height; i++) {
			sumNodes(tn,i,i%2==0);
		}
		return evenSum-oddSum;
	}

	private static void sumNodes(TreeNode tn, int i,boolean flag) {
		if(tn!=null)
		{
			if(i==1){
				System.out.println(tn.val);
				if(flag)
					evenSum+=tn.val;
				else
					oddSum+=tn.val;
			}
			sumNodes(tn.left, i-1,flag);
			sumNodes(tn.right, i-1,flag);
		}
		
	}

	private static int getHeight(TreeNode tn) {
		if(tn!=null)
		{
			return 1+Math.max(getHeight(tn.left), getHeight(tn.right));
		}
		return 0;
	}



}
