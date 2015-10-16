package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Link : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */

public class _116PopulatingNextRightPointers {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}

	public static void connect(TreeLinkNode root) {
		dfs(root);
	}
	
	private static void dfs(TreeLinkNode root) {
		Queue<TreeLinkNode> queue=new LinkedList<>();
		System.out.println();
		int level=0;
		TreeLinkNode tempNode = null;
		if(root!=null)
		{
			queue.add(root);
			while(!queue.isEmpty())
			{
				TreeLinkNode tn=queue.remove();
				if(tn.left!=null)
					queue.add(tn.left);
				if(tn.right!=null)
					queue.add(tn.right);
				System.out.println(tn.val);
				int height=getHeight(tn);
				if(height!=level && tempNode!=null)
				{
					tempNode.next=null;
					tempNode=tn;
					level=height;
				}
				else if(height==level && tempNode!=null)
				{
					tempNode.next=tn;
					tempNode=tn;
				}
				else{
					tempNode=tn;
					level=height;
				}
				
			}
		}
		
	}
	public static int getHeight(TreeLinkNode n)
	{
		if(n!=null)
		{
			int leftHeight=0;
			int rightHeight=0;
			if(n.left!=null)
				leftHeight=getHeight(n.left);
			if(n.right!=null)
				rightHeight=getHeight(n.right);
			return 1+Math.max(leftHeight, rightHeight);
			
		}
		return 0;
	}

	public static void main(String[] args) {
		TreeLinkNode tn=new TreeLinkNode(1);
		tn.left=new TreeLinkNode(2);
		tn.right=new TreeLinkNode(3);
		tn.left.right=new TreeLinkNode(5);
		tn.left.left=new TreeLinkNode(4);
		tn.right.right=new TreeLinkNode(7);
		tn.right.left=new TreeLinkNode(6);
		connect(tn);
		preOrder(tn);
	}

	private static void preOrder(TreeLinkNode tn) {
		if(tn!=null)
		{
			System.out.print(tn.val+"--");
			if(tn.next!=null)
			{
				System.out.print(tn.next.val);
			}
			System.out.println();
			preOrder(tn.left);
			preOrder(tn.right);	
		}
	}
	
	
	
	
	
	
	
	
	
}