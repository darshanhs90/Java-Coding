package appleInterview;

public class _DS_BT_06SizeOfBT {
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
		System.out.println(sizeOfTree(n));
	}
	private static int sizeOfTree(Node n) {
		if(n!=null)
		{
			return 1+sizeOfTree(n.left)+sizeOfTree(n.right);
		}
		else
			return 0;
	}
}

