package PracticeLeetCode;

public class _101SymmetricTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(1);
		tn1.left = new TreeNode(2);
		tn1.right = new TreeNode(2);
		tn1.left.left = new TreeNode(3);
		tn1.left.right = new TreeNode(4);
		tn1.right.left = new TreeNode(4);
		tn1.right.right = new TreeNode(3);
		System.out.println(isSymmetric(tn1));
		
		tn1 = new TreeNode(1);
		tn1.left = new TreeNode(2);
		tn1.right = new TreeNode(2);
		tn1.left.right = new TreeNode(3);
		tn1.right.right = new TreeNode(3);
		System.out.println(isSymmetric(tn1));
		
	}
	
    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
        {
        	return true;
        }
        return isSymmetric1(root.left, root.right);
    }
	
    public static boolean isSymmetric1(TreeNode left, TreeNode right) {
        if(left == null && right == null)
        {
        	return true;
        }
        else if((left == null && right != null) || (left != null && right == null)){
        	return false;
        }
        return left.val == right.val && isSymmetric1(left.left, right.right) && isSymmetric1(left.right, right.left);
    }
}
