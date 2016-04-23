package yelpInterview;

public class _BT42CheckFullBinaryTree {
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
		//n1.left.right=new Node(5);
		System.out.println(checkBinTree(n1));
	}
	private static boolean checkBinTree(Node n1) {
		if(n1!=null)
		{
			if(n1.left==null && n1.right==null)
				return true;
			if(n1.left!=null && n1.right!=null)
				return checkBinTree(n1.left) && checkBinTree(n1.right);
			return false;
		}
		return true;
	}


}

