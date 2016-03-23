package appleInterview;

public class _DS_BT_20NodesAtKDist {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left        = new Node(2);
		root.right       = new Node(3);
		root.left.left  = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(8);  
		printNodesAt(root,2);
	}
	private static void printNodesAt(Node root, int i) {
		if(root!=null)
		{
			if(i==0)
				System.out.println(root.value);
			else{
				printNodesAt(root.left, i-1);
				printNodesAt(root.right, i-1);
			}
		}

	}



}

