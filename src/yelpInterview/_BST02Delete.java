package yelpInterview;

public class _BST02Delete {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node root=insert(null,10);
		insert(root,20);
		insert(root,30);
		insert(root,40);
		insert(root,50);
		insert(root,5);
		insert(root,7);
		inOrder(root);
		deleteNode(root,40);
		System.out.println();
		inOrder(root);

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
	private static void inOrder(Node n) {
		if(n!=null)
		{	
			inOrder(n.left);
			System.out.print(n.value+" ");
			inOrder(n.right);			
		}
	}





}