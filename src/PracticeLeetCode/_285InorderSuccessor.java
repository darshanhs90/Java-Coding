package PracticeLeetCode;

public class _285InorderSuccessor {
	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(20);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(22);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(12);
		tn.left.right.left=new TreeNode(10);
		tn.left.right.right=new TreeNode(14);
		System.out.println(inorderSuccessor(tn,tn.left).value);
	}


}
