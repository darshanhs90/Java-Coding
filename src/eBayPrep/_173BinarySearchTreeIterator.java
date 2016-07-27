package eBayPrep;

import java.util.Stack;

public class _173BinarySearchTreeIterator {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static Stack<TreeNode> stack;
	public _173BinarySearchTreeIterator(TreeNode tn) {
		stack=new Stack<>();
		if(tn!=null){
			stack.push(tn);
			while(tn!=null && tn.left!=null)
			{
				stack.push(tn.left);
				tn=tn.left;
			}
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		if(hasNext())
		{
			TreeNode tn=stack.pop();
			int value=tn.val;
			if(tn.right!=null)
				stack.push(tn.right);
			tn=tn.right;
			while(tn!=null && tn.left!=null)
			{
				stack.push(tn.left);
				tn=tn.left;
			}
			return value;
		}
		else
			return -1;
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(5);
		tn.left=new TreeNode(3);
		tn.right=new TreeNode(6);
		_173BinarySearchTreeIterator i = new _173BinarySearchTreeIterator(tn);
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}

