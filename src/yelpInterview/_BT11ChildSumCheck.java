package yelpInterview;

public class _BT11ChildSumCheck {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(10);
		n.left=new Node(8);
		n.right=new Node(2);
		n.left.left=new Node(3);
		n.left.right=new Node(5);
		n.right.left=new Node(2);
		System.out.println(checkChildSum(n));System.out.println();
	}
	private static boolean checkChildSum(Node n) {
		if(n!=null){
			if(n.left==null && n.right==null)
				return true;
			int leftVal=n.left!=null?n.left.value:0;
			int rightVal=n.right!=null?n.right.value:0;
			return n.value==leftVal+rightVal && checkChildSum(n.left) && checkChildSum(n.right);
		}
		return true;
	}

}

