package yelpInterview;

public class _BST12EachNodeOneLeaved {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		/*Node n=insert(null,20);
		insert(n,10);
		insert(n,11);
		insert(n,13);
		insert(n,12);*/
		Node n=insert(null,8);
		insert(n,3);
		insert(n,5);
		insert(n,7);
		insert(n,6);
		inOrderTraversal(n);
		System.out.println();
		System.out.println(checkNodes(n));
	}

	private static boolean checkNodes(Node n) {
		if(n!=null)
		{
			if(n.left==null && n.right==null)
				return true;
			if(n.left==null||n.right==null)
			{
				Node temp=n.left!=null?n.left:n.right;
				return checkNodes(temp);
			}
			else{
				return false;
			}
		}
		return true;
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