package yelpInterview;

public class _BST11RemoveBSTKeysOutsideRange {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=insert(null,6);
		insert(n,-13);
		insert(n,-8);
		insert(n,14);
		insert(n,13);
		insert(n,15);
		insert(n,7);
		inOrderTraversal(n);
		System.out.println();
		removeNodes(n,n,-10,13);
		inOrderTraversal(n);
	}
	private static void removeNodes(Node n,Node n1, int i, int j) {
		if(n1!=null)
		{
			removeNodes(n,n1.left, i, j);
			removeNodes(n,n1.right, i, j);
			if(n1.value<i||n1.value>j)
				deleteNode(n,n1.value);
		}
	}
	private static void inOrderTraversal(Node n) {
		if(n!=null)
		{
			inOrderTraversal(n.left);
			System.out.print(n.value+" ");
			inOrderTraversal(n.right);
		}
	}

	private static Node  deleteNode(Node n, int value) {
		if(n==null)
			return n;
		if(n.value>value)
			n.left=deleteNode(n.left, value);
		else if(n.value<value)
			n.right=deleteNode(n.right, value);
		else{
			if(n.left==null)
			{
				return n.right;
			}
			else if(n.right==null)
			{
				return n.left;
			}
			Node n1=getMinValueNode(n.right);
			n.value=n1.value;
			n.right=deleteNode(n.right, n.value);
		}
		return n;
	}

	private static Node getMinValueNode(Node n) {
		if(n==null)
			return n;
		while(n.left!=null)
			n=n.left;
		return n;
	}


	private static Node insert(Node n, int value) {
		if(n==null)
			return new Node(value);
		if(n.value>value)
		{//move left
			n.left=insert(n.left,value);
		}
		else{//move right
			n.right=insert(n.right,value);			
		}
		return n;
	}

}