package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _145PostOrderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left,right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
	static List<Integer> outputList;
	public List<Integer> postorderTraversal(TreeNode root) {
		outputList=new ArrayList<>();
		postOrder(root);
		return outputList;
	}
	private void postOrder(TreeNode root) {
		if(root!=null)
		{
			postOrder(root.left);
			postOrder(root.right);
			outputList.add(root.val);
		}
	}
}