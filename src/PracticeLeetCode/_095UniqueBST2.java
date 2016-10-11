package PracticeLeetCode;

import java.util.List;

public class _095UniqueBST2 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		List<TreeNode> outputList=generateTrees(3);
		for (int i = 0; i < outputList.size(); i++) {
			TreeNode tn=outputList.get(i);
			//preOrder(tn);
			System.out.println();
		}
	}

	public static List<TreeNode> generateTrees(int n) {


	}
}
