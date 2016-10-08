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
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> outputList=new ArrayList<>();
		if(root==null)
			return outputList;
		postOrder(root,outputList);
		return outputList;
	}
	private void postOrder(TreeNode root, List<Integer> outputList) {
		if(root==null)
			return ;
		postOrder(root.left, outputList);
		postOrder(root.right, outputList);
		outputList.add(root.val);
	}
}