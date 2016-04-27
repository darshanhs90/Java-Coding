package yelpInterview;

public class _BST03MinimumValueNode {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node root=insert(null, 4);
		insert(root, 2);
		insert(root, 1);
		insert(root, 3);
		insert(root, 6);
		insert(root, 5);  
		inOrder(root);
		System.out.println();
		System.out.println(findMinValueNode(root).value);

	}



	private static Node findMinValueNode(Node n) {
		if(n==null)
			return null;
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