package yelpInterview;

public class _BST01SearchInsert {
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
		System.out.println(search(root,20));
		System.out.println(search(root,25));

	}
	private static boolean search(Node n, int value) {
		if(n==null)
			return false;
		if(n.value==value)
			return true;
		if(n.value>value)
			return search(n.left,value);
		else
			return search(n.right,value);
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
			System.out.println(n.value);
			inOrder(n.right);			
		}
	}





}