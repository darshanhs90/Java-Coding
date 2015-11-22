package GeeksforGeeksPractice;

import java.util.LinkedList;
import java.util.Queue;

public class _0024BinaryTreeCompleteCheck {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(-2);
		tn.right=new TreeNode(7);
		tn.left.left=new TreeNode(8);
		tn.left.right=new TreeNode(-4);
		System.out.println(checkBinaryTree(tn));//true
	}
	private static boolean checkBinaryTree(TreeNode tn) {
		Queue<TreeNode> q=new LinkedList<>();
		if(tn!=null)
		{
			q.add(tn);
		}
		boolean flag=false;
		while(!q.isEmpty())
		{
			TreeNode temp=q.poll();
			System.out.println(temp.val);
			if(temp.left!=null){
				if(flag==true)
					return false;
				q.add(temp.left);
			}
			else
				flag=true;
			if(temp.right!=null){
				if(flag==true)
					return false;
				q.add(temp.right);
			}
			else
				flag=true;
		}
		return true;
	}

}
