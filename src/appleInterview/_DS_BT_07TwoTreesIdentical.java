package appleInterview;

public class _DS_BT_07TwoTreesIdentical {
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
		System.out.println(isIdentical(n,n));
		n=new Node(1);
		n.left=new Node(2);
		n.right=new Node(3);
		n.left.left=new Node(4);
		n.left.right=new Node(5);
		Node n1=new Node(1);
		n1.left=new Node(2);
		n1.right=new Node(3);
		n1.left.left=new Node(4);
		n1.left.right=new Node(51);
		System.out.println(isIdentical(n, n1));
	}
	private static boolean isIdentical(Node n1,Node n2){
		if(n1!=null && n2!=null)
		{
			return isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right) && n1.value==n2.value;
		}
		else if(n1!=null || n2!=null){
			return false;
		}
		return true;
	}
}

