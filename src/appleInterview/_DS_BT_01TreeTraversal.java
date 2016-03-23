package appleInterview;

public class _DS_BT_01TreeTraversal {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node n=new Node(1);
		n.left=new Node(2);
		n.right=new Node(3);
		n.left.left=new Node(4);
		n.left.right=new Node(5);
		preOrder(n);
		System.out.println();
		postOrder(n);
		System.out.println();
		inOrder(n);
		System.out.println();
	}
	private static void postOrder(Node n) {
		if(n!=null)
		{
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n.value+"->");
		}
	}
	private static void preOrder(Node n) {
		if(n!=null)
		{
			System.out.print(n.value+"->");
			preOrder(n.left);
			preOrder(n.right);
		}
	}
	private static void inOrder(Node n) {
		if(n!=null)
		{
			inOrder(n.left);
			System.out.print(n.value+"->");
			inOrder(n.right);
		}
	}

}
