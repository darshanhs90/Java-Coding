package yelpInterview;

public class _BT16PrintNodesAtKFromLeaf {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(50);
		n.left=new Node(7);
		n.right=new Node(2);
		n.left.left=new Node(3);
		n.left.right=new Node(5);
		n.right.left=new Node(1);
		n.right.right=new Node(30);
		printNodesKDist(n,path,0,0);
		System.out.println();
	}
	private static  void printNodesKDist(Node n, int[] path, int i, int k) {
		if(n!=null)
		{
			path[i]=n.value;
			if(n.left==null && n.right==null)
			{
				if(i-k>=0)
					System.out.println(path[i-k]);
			}
			printNodesKDist(n.left, path, i+1, k);
			printNodesKDist(n.right, path, i+1, k);
		}
	}
	static int[] path=new int[100];


}

