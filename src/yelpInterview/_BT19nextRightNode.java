package yelpInterview;

public class _BT19nextRightNode {
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
		n.right.left.right=new Node(8);
		nextRightNode(n,2);
	}
	private static void nextRightNode(Node n, int nodeVal) {
		for (int i = 0; i < getHeight(n); i++) {
			levelOrder(n,i,nodeVal);
			if(sb.toString().contains("/"+nodeVal+"/"))//find next from string manipulation
				break;
		}
		System.out.println(sb.toString());
	}
	static StringBuilder sb=new StringBuilder();
	private static void levelOrder(Node n, int i,int nodeVal) {
		if(n!=null)
		{
			if(i==0)
			{
				sb.append("/"+n.value+"/");
			}
			else if(i>0)
			{
				levelOrder(n.left, i-1, nodeVal);
				levelOrder(n.right, i-1, nodeVal);
			}
		}
	}
	private static int getHeight(Node n) {
		return n!=null?1+Math.max(getHeight(n.left), getHeight(n.right)):0;
	}

}

