package yelpInterview;

public class _BT39FoldableBT {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(10);
		n.left=new Node(7);
		n.right=new Node(15);
		n.left.right=new Node(9);
		//n.right.left=new Node(11);
		n.right.right=new Node(11);
		System.out.println(isFoldable(n));
	}
	private static boolean isFoldable(Node n) {
		if(n!=null)
		{
			mirror(n.left);
			boolean res=isStructureSam(n.left,n.right);
			mirror(n.left);
			return res;
		}
		return true;
	}
	private static boolean isStructureSam(Node n1, Node n2) {
		if(n1==null && n2==null)
			return true;
		if((n1!=null && n2!=null) && isStructureSam(n1.left, n2.left) && isStructureSam(n1.right, n2.right))
			return true;
		return false;
	}
	private static void mirror(Node n) {
		if(n!=null)
		{
			mirror(n.left);
			mirror(n.right);
			Node temp=n.left;
			n.left=n.right;
			n.right=temp;
		}

	}
}

