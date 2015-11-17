package GeeksforGeeksPractice;

import java.util.LinkedList;
import java.util.Queue;

public class _0006LevelOrderTraversal {
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(4);
		tn.left.left=new TreeNode(5);
		tn.left.left.left=new TreeNode(6);
		tn.left.left.left.left=new TreeNode(7);
		levelOrderTraversal(tn);
		//1/2/3/5/4/6/7/
	}
	public static void levelOrderTraversal(TreeNode tn)
	{	
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		if(tn!=null)
		{
			q.add(tn);
		}
		while(!q.isEmpty())
		{
			TreeNode tnNew=q.poll();
			System.out.print(tnNew.val+"/");
			if(tnNew.left!=null)
				q.add(tnNew.left);
			if(tnNew.right!=null)
				q.add(tnNew.right);
		}
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


}
