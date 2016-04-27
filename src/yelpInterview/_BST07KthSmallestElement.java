package yelpInterview;

public class _BST07KthSmallestElement {
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
		inOrder(root,4);

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
	static int counter=0;
	private static void inOrder(Node n,int k) {
		if(n!=null)
		{	
			inOrder(n.right,k);
			if(counter==k){
				System.out.print(n.value+" ");
				counter++;
				return;
			}
			counter++;
			inOrder(n.left,k);			
		}
	}







}