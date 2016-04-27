package yelpInterview;

public class _BST08PrintKeysRanged {
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
		printValues(root,7,19);
	}

	private static void printValues(Node n,int low, int high) {
		if(n==null)
			return;
		if(n.value>low && n.value<high)
		{
			System.out.println(n.value);
			printValues(n.left, low, high);
			printValues(n.right, low, high);	
		}
		else{
			if(n.value>high)
				printValues(n.left, low, high);
			else
				printValues(n.right, low, high);
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