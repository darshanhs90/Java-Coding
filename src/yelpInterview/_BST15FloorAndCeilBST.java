package yelpInterview;

public class _BST15FloorAndCeilBST {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=insert(null,8);
		insert(n,4);
		insert(n,12);
		insert(n,2);
		insert(n,6);
		insert(n,10);
		insert(n,14);
		inOrderTraversal(n);
		System.out.println();
		for (int i = 0; i < 16; i++) {
			System.out.println(i+"/"+findCeil(n,i)+"/"+findFloor(n,i));
		}
	}


	private static int findFloor(Node n, int value) {
		if(n!=null)
		{
			if(n.value==value)
				return value;
			if(n.value>value)
				return findFloor(n.left, value);
			int ceil=findFloor(n.right, value);
			return ceil>=n.value?ceil:n.value;
		}
		return -1;
	}


	private static int findCeil(Node n, int value) {
		if(n!=null)
		{
			if(n.value==value)
				return value;
			if(n.value<value)
				return findCeil(n.right, value);
			int ceil=findCeil(n.left, value);
			return ceil>=value?ceil:n.value;
				
		}
		return -1;
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