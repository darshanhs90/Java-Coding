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
    public List<Integer> preorderTraversal(TreeNode root) {
    	 List<Integer> outputList=new ArrayList<>();
    	 if(root==null)
    		 return outputList;
    	 preOrder(root,outputList);
    	 return outputList;
    }
	private void preOrder(TreeNode root, List<Integer> outputList) {
		if(root==null)
			return ;
		outputList.add(root.val);
		preOrder(root.left, outputList);
		preOrder(root.right, outputList);
	}
}