package yelpInterview;

public class _BST21SecondLargestElement{
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=insert(null,10);
		insert(n,5);
		insert(n,20);
		insert(n,30);
		inOrderTraversal(n);
		System.out.println();
		findSecondLargestElement(n);
	}









	static int c=0;
	private static void findSecondLargestElement(Node n) {
		if(n!=null){
			findSecondLargestElement(n.left);
			if(c==2)
				System.out.println(n.value);
			c++;
			findSecondLargestElement(n.right);
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