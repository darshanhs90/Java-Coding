package LeetCodePractice;

public class _116PopulatingNextRightPointersinEachNode {

	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		TreeLinkNode tn=new TreeLinkNode(1);
		tn.left=new TreeLinkNode(2);
		tn.right=new TreeLinkNode(3);
		tn.left.left=new TreeLinkNode(4);
		tn.left.right=new TreeLinkNode(5);
		tn.right.left=new TreeLinkNode(6);
		tn.right.right=new TreeLinkNode(7);
		connect(tn);
	}



	public static void connect(TreeLinkNode root) {
		reverseLevelOrderTraversal(root);
		preOrder(root);
	}



	private static void preOrder(TreeLinkNode root) {
		if(root!=null)
		{
			preOrder(root.left);
			if(root.next==null)
			{
				System.out.println(root.val+"/null");
			}
			else{
				System.out.println(root.val+"/"+root.next.val);
			}
			preOrder(root.right);
		}
	}



	private static void reverseLevelOrderTraversal(TreeLinkNode root) {
		int height=getHeight(root);
		for (int i = 0; i < height; i++) {
			present=null;
			printNodes(root,i);
			System.out.println();
		}
	}

	static TreeLinkNode present=null;

	private static void printNodes(TreeLinkNode root, int i) {
		if(root==null)return;
		if(i==0)
		{
			if(present==null){
				root.next=null;
				present=root;
			}
			else{
				root.next=present;
				present=root;
			}
		}
		printNodes(root.right, i-1);
		printNodes(root.left, i-1);
	}



	private static int getHeight(TreeLinkNode root) {
		return root==null?0:1+Math.max(getHeight(root.left), getHeight(root.right));
	}

}

