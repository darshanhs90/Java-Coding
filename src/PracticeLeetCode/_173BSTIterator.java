package PracticeLeetCode;

import java.util.Stack;

public class _173BSTIterator {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(5);
		tn.right=new TreeNode(15);
		tn.left.left=new TreeNode(2);
		tn.left.right=new TreeNode(8);
		tn.right.left=new TreeNode(12);
		tn.right.right=new TreeNode(18);
		BSTIterator itr=new BSTIterator(tn);
		while(itr.hasNext())
		{
			System.out.println(itr.next()+"/");
		}
	}
	static public class BSTIterator {
		
	}
}