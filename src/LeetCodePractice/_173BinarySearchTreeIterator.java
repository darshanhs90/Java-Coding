package LeetCodePractice;

import java.util.Stack;

public class _173BinarySearchTreeIterator {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	Stack<TreeNode> stack;
	public _173BinarySearchTreeIterator(TreeNode root) {
		stack=new Stack<>();
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
		TreeNode tn=stack.pop();
		TreeNode tn1=tn.right;
		while(tn1!=null)
		{
			stack.push(tn1);
			tn1=tn1.left;
		}
		return tn.val;
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

