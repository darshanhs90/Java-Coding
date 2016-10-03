package hackerRank.CrackingTheCodingInterview;

public class _07BSTCheck {

	class Node {
		int data;
		Node left;
		Node right;
	}

	boolean checkBST(Node root) {
		if(root==null)
			return true;
		return validateBST(Integer.MIN_VALUE,root.left,root.data) && 
				validateBST(root.data,root.right,Integer.MAX_VALUE);
	}

	private boolean validateBST(int minValue, Node node, int maxValue) {
		if(node==null)
			return true;
		return node.data>minValue && 
				node.data<maxValue &&
				validateBST(minValue, node.left, node.data) && 
				validateBST(node.data, node.right, maxValue);
	}
}
	