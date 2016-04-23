package yelpInterview;

public class _BT44PrintAncestors {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n1=new Node(1);
		n1.left=new Node(2);
		n1.right=new Node(3);
		n1.left.left=new Node(4);
		n1.left.right=new Node(5);
		n1.left.left.left=new Node(7);
		printAncestors(n1,4);
	}
	private static boolean printAncestors(Node n1, int i) {
		if(n1!=null)
		{
			if(n1.value==i){
				return true;
			}
			if(printAncestors(n1.left, i) || printAncestors(n1.right, i)){
				System.out.println(n1.value);
				return true;
			}

		}
		return false;
	}

}

