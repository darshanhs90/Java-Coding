package leetCode;

/*
 * Link : https://leetcode.com/problems/same-tree/
 */

public class _100SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null)
			return true;
		else
			if(p!=null && q !=null)
				return (p.val==q.val && isSameTree(p.left, q.left)&& isSameTree(p.right, q.right));			
			return false;
	}
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
}