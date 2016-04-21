package yelpInterview;

public class _BT18findLCA {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(1);
		n.left=new Node(2);
		n.right=new Node(3);
		n.left.left=new Node(4);
		n.left.right=new Node(5);
		n.right.left=new Node(6);
		n.right.right=new Node(7);
		n.right.left.right=new Node(8);
		System.out.println(findLCA(n,4,5).value);
	}
	private static Node findLCA(Node n, int i, int j) {
		if(n!=null){
			if(n.value==i||n.value==j)
				return n;
			Node left=findLCA(n.left, i, j);
			Node right=findLCA(n.right, i, j);
			if(left!=null && right!=null)
				return n;
			return left != null? left: right;
		}
		return n;
	}


}

