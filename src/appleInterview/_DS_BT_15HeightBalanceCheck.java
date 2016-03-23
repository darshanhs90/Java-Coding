package appleInterview;

public class _DS_BT_15HeightBalanceCheck {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		//root.left.left.left = new Node(8);
		System.out.println(checkBalance(root));
	}
	private static boolean checkBalance(Node tn) {
		if(tn!=null)
		{
			return checkBalance(tn.left) && checkBalance(tn.right) && (Math.abs(getHeight(tn.left)-getHeight(tn.right))<=1);
		}
		return true;
	}
	private static int getHeight(Node tn) {
		if(tn!=null)
			return 1+Math.max(getHeight(tn.left), getHeight(tn.right));
		return 0;
	}



}

