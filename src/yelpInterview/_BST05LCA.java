package yelpInterview;

public class _BST05LCA {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node root=insert(null, 20);
		insert(root, 8);
		insert(root, 22);
		insert(root, 4);
		insert(root, 12);
		insert(root, 10);
		insert(root, 14);
		inOrder(root);
		System.out.println();
		System.out.println(findLCA(root,10,14).value);
		System.out.println(findLCA(root,8,14).value);
		System.out.println(findLCA(root,10,22).value);
	}



	private static Node findLCA(Node n,int num1, int num2) {
		if(n==null)
			return n;
		if(n.value>num1 && n.value>num2)
		{
			return findLCA(n.left, num1, num2);
		}
		else if(n.value<num1 && n.value<num2)
		{
			return findLCA(n.right, num1, num2);
		}
		return n;
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