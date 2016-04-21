package yelpInterview;

public class _BT25PrintNodesBetweenLevels {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(20);
		n.left=new Node(8);
		n.right=new Node(22);
		n.left.left=new Node(4);
		n.left.right=new Node(12);
		n.left.right.left=new Node(10);
		n.left.right.right=new Node(14);
		findNodes(n,2,4);
	}
	private static void findNodes(Node n, int lowLevel, int highLevel) {
		for (int i = lowLevel; i <=highLevel; i++) {
			printNodes(n,i);
		}

	}
	private static void printNodes(Node n, int i) {
		if(n!=null)
		{
			if(i==1)
				System.out.println(n.value);
			else if(i>1)
			{
				printNodes(n.left, i-1);
				printNodes(n.right, i-1);
			}
		}
	}

}

