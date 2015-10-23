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
	}
	public static void levelOrderTraversal(TreeNode tn)
	{
		if(tn!=null)
		{

		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(tn);
		while(!queue.isEmpty()) 
		{
			TreeNode poppedNode=queue.poll();
			System.out.println(poppedNode.val);
			if(poppedNode.left!=null)
				queue.add(poppedNode.left);
			if(poppedNode.right!=null)
				queue.add(poppedNode.right);
		}
		}
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


}
