package yelpInterview;

public class _BST16BSTSummedUp {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=insert(null,5);
		insert(n,2);
		insert(n,13);
		inOrderTraversal(n);
		System.out.println();
		getSum(n);
		changeNodes(n);
		inOrderTraversal(n);
	}



	static int sum=0;
	private static void changeNodes(Node n) {
		if(n!=null)
		{
			changeNodes(n.left);
			int temp=n.value;
			n.value=sum;
			sum-=temp;
			changeNodes(n.right);
		}
	}
	private static void getSum(Node n) {
		if(n!=null)
		{
			getSum(n.left);
			sum+=n.value;
			getSum(n.right);
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