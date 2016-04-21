package yelpInterview;

public class _BT23PrintNodesAtDistKRoot {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(1);
		n.left=new Node(2);
		n.right=new Node(3);
		n.left.left=new Node(4);
		n.right.left=new Node(5);
		n.right.right=new Node(6);
		n.right.left.right=new Node(7);
		n.right.left.right.left=new Node(9);
		n.right.right.right=new Node(8);
		n.right.right.right.right=new Node(10);
		printNodesK(n,2);
	}
	private static void printNodesK(Node n,int k) {
		if(n!=null)
		{
			printNodesKUtil(n,k,0);
		}
	}
	private static void printNodesKUtil(Node n, int k, int distance) {
		if(n!=null)
		{
			if(distance==k)
				System.out.println(n.value);
			printNodesKUtil(n.left, k,distance+1);
			printNodesKUtil(n.right, k,distance+1);
		}
	}

}

