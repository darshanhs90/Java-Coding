package GeeksforGeeksPractice;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Link : http://www.geeksforgeeks.org/find-sum-left-leaves-given-binary-tree/
 */
public class _0052SumOfLeftLeaves {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(20);
		tn.left=new TreeNode(9);
		tn.right=new TreeNode(49);
		tn.left.left=new TreeNode(5);
		tn.left.right=new TreeNode(12);
		tn.left.right.right=new TreeNode(15);
		tn.right.left=new TreeNode(23);
		tn.right.right=new TreeNode(52);
		tn.right.right.left=new TreeNode(50);
		System.out.println(findLeftLeafSum(tn));
	}

	private static int findLeftLeafSum(TreeNode tn) {
		if(tn!=null)
		{
			return  (findSum(tn.left,true)+findSum(tn.right,false));
		}
		return 0;
	}

	private static int findSum(TreeNode tn, boolean isLeftFlag) {
		if(tn!=null)
		{
			if(tn.left==null && tn.right==null && isLeftFlag)
			{
				return tn.value;
			}
			return findSum(tn.left, true) + findSum(tn.right, false);
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
