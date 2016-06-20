package LeetCodePractice;

import java.util.ArrayList;
import java.util.List;

public class _144BinaryTreePreorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static  List<Integer> outputList;
	public List<Integer> preorderTraversal(TreeNode root) {
		outputList=new ArrayList<>();
		preOrder(root);
		return outputList;
	}
	private void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			outputList.add(tn.val);
			preOrder(tn.left);
			preOrder(tn.right);
		}
		
	}
}

