package appleInterview;

public class _DS_BT_17DoubleTree {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	static Node oldLeft=null;
	public static void main(String[] args) {
		Node root=new Node(2);
		root.left=new Node(1);
		root.right=new Node(3);
		doubleTree(root);
		inorder(root);
		System.out.println();
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		doubleTree(root);
		inorder(root);
	}

	private static void doubleTree(Node tn) {
		if(tn!=null)
		{
			doubleTree(tn.left);
			doubleTree(tn.right);
			oldLeft=tn.left;
			tn.left=new Node(tn.value);
			tn.left.left=oldLeft;
		}

	}
	private static void inorder(Node root) {
		if(root!=null)
		{
			System.out.print(root.value+"/");
			inorder(root.left);
			inorder(root.right);
		}
	}


}

