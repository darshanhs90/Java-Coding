package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _144PreOrderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left,right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {


	}
	static List<Integer> outputList;
	public List<Integer> preorderTraversal(TreeNode root) {
		outputList=new ArrayList<>();
		preOrder(root);
		return outputList;
	}
	private void preOrder(TreeNode root) {
		if(root!=null)
		{
			outputList.add(root.val);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
}