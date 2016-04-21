package yelpInterview;

public class _BT24GetLevelOfNode {
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
		n.right.left=new Node(5);
		n.right.right=new Node(6);
		n.right.left.right=new Node(7);
		n.right.left.right.left=new Node(9);
		n.right.right.right=new Node(8);
		n.right.right.right.right=new Node(10);
		getLevel(n,9);
		System.out.println(level);
	}
	private static void getLevel(Node n, int nodeVal) {
		if(n!=null)
		{
			getLevelUtil(n,nodeVal,1);
		}
	}
	private static void getLevelUtil(Node n, int nodeVal, int i) {
		if(n!=null)
		{
			if(n.value==nodeVal)
				level=i;
			else{
				getLevelUtil(n.left, nodeVal, i+1);
				getLevelUtil(n.right, nodeVal, i+1);
			}
		}
	}
	static int level=0;

}

