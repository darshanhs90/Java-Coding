package appleInterview;

public class _DS_BT_11LevelOrderTraversalSpiral {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node n=new Node(1);
		n.left=new Node(2);
		n.right=new Node(3);
		n.left.left=new Node(4);
		n.left.right=new Node(5);
		levelSpiral(n);
	}
	private static void levelSpiral(Node n) {
		int height=getHeight(n);
		for (int i = 0; i < height; i++) {
			printOrder(n,i,i%2==0);
		}
	}
	private static int getHeight(Node n) {
		if(n!=null)
			return 1+Math.max(getHeight(n.left),getHeight(n.right));
		return 0;
	}
	private static void printOrder(Node n, int i, boolean b) {
		if(n!=null)
		{
			if(i==0)
				System.out.print(n.value+" ");
			else
				if(b)
				{
					printOrder(n.left, i-1, b);
					printOrder(n.right, i-1, b);
				}
				else{
					printOrder(n.right, i-1, b);
					printOrder(n.left, i-1, b);
				}
		}
	}
}

