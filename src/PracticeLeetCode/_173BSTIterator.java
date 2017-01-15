package PracticeLeetCode;

import java.util.LinkedList;
import java.util.Queue;
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
		Stack<TreeNode> stack=new Stack<>();
	    public BSTIterator(TreeNode root) {
	    	if(root==null)
	    		return;
	    	while(root!=null)
	    	{
	    		stack.push(root);
	    		root=root.left;
	    	}
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        if(hasNext()){
	        	TreeNode top=stack.pop();
	        	int val=top.val;
	        	if(top.right!=null)
	        	{
	        		top=top.right;
	        		while(top!=null)
	        		{
	        			stack.push(top);
	        			top=top.left;
	        		}
	        	}
	        	return val;
	        }
	        return -1;
	    }
	}
}