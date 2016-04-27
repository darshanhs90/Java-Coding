package yelpInterview;

public class _BST10AddAllGreaterElements {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=insert(null,50);
		insert(n,30);
		insert(n,70);
		insert(n,20);
		insert(n,40);
		insert(n,60);
		insert(n,80);
		inOrderTraversal(n);
		System.out.println();
		sum=(inOrderSum(n));
		inOrderChange(n);
		inOrderTraversal(n);
	}
	private static void inOrderTraversal(Node n) {
		if(n!=null)
		{
			inOrderTraversal(n.left);
			System.out.print(n.value+" ");
			inOrderTraversal(n.right);
		}
	}
	static int sum;
	private static void inOrderChange(Node n) {
		if(n!=null)
		{
			inOrderChange(n.left);
			int temp=n.value;
			n.value=sum;
			sum-=temp;
			inOrderChange(n.right);
		}
	}

	private static int inOrderSum(Node n) {
		if(n!=null)
		{
			return n.value+inOrderSum(n.left)+inOrderSum(n.right);
		}
		return 0;
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