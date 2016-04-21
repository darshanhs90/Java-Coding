package yelpInterview;

public class _BT10LevelOrderSpiralForm {
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
		levelOrderSpiral(n);System.out.println();
	}
	private static void levelOrderSpiral(Node n) {
		if(n!=null)
		{
			boolean flag=true;
			for (int i = 0; i < getHeight(n); i++) {
				printNodes(n,i,flag);
				flag=!flag;
			}
		}
	}
	private static void printNodes(Node n, int i, boolean flag) {
		if(n!=null)
		{
			if(i==0)
				System.out.println(n.value);
			else if(i>0)
			{
				if(flag)
				{
					printNodes(n.left, i-1, flag);
					printNodes(n.right, i-1, flag);
				}else{
					printNodes(n.right, i-1, flag);
					printNodes(n.left, i-1, flag);
				}
			}

		}
	}
	private static int getHeight(Node n) {
		if(n!=null)
		{
			return 1+Math.max(getHeight(n.left), getHeight(n.right));
		}
		return 0;
	}

}

