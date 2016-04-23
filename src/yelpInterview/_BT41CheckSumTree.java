package yelpInterview;

public class _BT41CheckSumTree {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n1=new Node(26);
		n1.left=new Node(10);
		n1.right=new Node(3);
		n1.left.left=new Node(4);
		n1.left.right=new Node(6);
		n1.right.right=new Node(3);
		System.out.println(checkSum(n1));
	}
	private static boolean checkSum(Node n1) {
		if(n1==null || (n1.left==null && n1.right==null))
			return true;
		return (n1.value==checkSumUtil(n1.left)+checkSumUtil(n1.right)) && checkSum(n1.left) && checkSum(n1.right);
	}
	private static int checkSumUtil(Node n1) {
		if(n1!=null)
		{
			return n1.value+checkSumUtil(n1.left)+checkSumUtil(n1.right);
		}
		return 0;
	}


}

