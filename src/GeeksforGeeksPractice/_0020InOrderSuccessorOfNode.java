package GeeksforGeeksPractice;

public class _0020InOrderSuccessorOfNode {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(30);
		inOrder(tn);
		System.out.println("*****************");
		populateInorderSuccessor(tn);
		inOrder(tn);
	}
	static TreeNode temp;
	private static void populateInorderSuccessor(TreeNode tn) {
		if(tn!=null)
		{
			populateInorderSuccessor(tn.right);
			if(temp==null)
			{
				temp=tn;
			}
			else{
				tn.next=temp;
				temp=tn;
			}
			populateInorderSuccessor(tn.left);
		}

	}
	private static void inOrder(TreeNode tn) {
		if(tn!=null){
			inOrder(tn.left);
			if(tn.next==null)
				System.out.println(tn.val+"//null");
			else
				System.out.println(tn.val+"//"+tn.next.val);
			inOrder(tn.right);
		}
	}
}
