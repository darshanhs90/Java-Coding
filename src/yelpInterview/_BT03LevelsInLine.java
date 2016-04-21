package yelpInterview;

public class _BT03LevelsInLine {

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
		n.left.right=new Node(5);
		n.right.left=new Node(6);
		n.right.right=new Node(7);
		levelsInLineOrder(n);System.out.println();
	}
	private static void levelsInLineOrder(Node n) {
		for (int i = 0; i < getHeight(n); i++) {
			printNode(n,i);
			System.out.println();
		}

	}
	private static void printNode(Node n, int i) {
		if(n!=null)
		{
			if(i==0)
				System.out.print(n.value+" ");
			else if(i>0){
				printNode(n.left, i-1);
				printNode(n.right, i-1);
			}
		}

	}
	private static int getHeight(Node n) {
		if(n!=null)
			return 1+Math.max(getHeight(n.left), getHeight(n.right));
		return 0;
	}

}

