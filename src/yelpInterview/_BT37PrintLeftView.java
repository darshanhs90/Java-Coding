package yelpInterview;

public class _BT37PrintLeftView {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(12);
		n.left=new Node(10);
		n.right=new Node(30);
		n.right.left=new Node(25);
		n.right.right=new Node(40);
		printLeftView(n);
	}
	static boolean printed=false;
	private static void printLeftView(Node n) {
		for (int i = 0; i < getHeight(n); i++) {
			printed=false;
			printNode(n,i);
		}
	}
	private static void printNode(Node n, int level) {
		if(n!=null)
		{
			if(level==0 && !printed){
				System.out.println(n.value);
				printed=true;
			}
			printNode(n.left, level-1);
			printNode(n.right, level-1);
		}

	}
	private static int getHeight(Node n) {
		return n!=null?1+Math.max(getHeight(n.left), getHeight(n.right)):0;
	}

}

