package careerCup;

import java.util.HashSet;
import java.util.Set;

/*
 * Link: http://www.careercup.com/question?id=208906
 * Given a tree in which each node is an integer and an array with a set of integers.
 * Determine if all the elements of the array are present in the tree by visiting each node in the tree at most once.
 */
public class _19googleCareerCup {
	static  Set<Integer> elementSet=new HashSet<Integer>();
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		tn.left.left.left=new TreeNode(8);
		int[] inputArray=new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println(checkElements(tn,inputArray));
	}
	private static boolean checkElements(TreeNode tn, int[] inputArray) {
		inorder(tn);
		for (int i = 0; i < inputArray.length; i++) {
			if(!elementSet.contains(inputArray[i]))
			{
				return false;
			}
		}
		return true;
	}
	private static void inorder(TreeNode tn) {
		if(tn!=null){
			inorder(tn.left);
			inorder(tn.right);
			elementSet.add(tn.val);
		}
	}
	static class TreeNode{
		int val;
		TreeNode left,right;
		public TreeNode(int val) {
			this.val=val;
		}
	}
}
