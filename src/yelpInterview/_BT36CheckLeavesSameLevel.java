package yelpInterview;

public class _BT36CheckLeavesSameLevel {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(12);
		n.left=new Node(2);
		n.right=new Node(3);
		n.left.left=new Node(4);
		n.right.left=new Node(5);
		System.out.println(checkSameLevelLeaf(n));
	}
	private static boolean checkSameLevelLeaf(Node n) {
		if(n!=null)
		{
			return checkLeafUtil(n,0);
		}
		return true;
	}
	static int currLevel=-1;
	private static boolean checkLeafUtil(Node n, int i) {
		if(n!=null)
		{
			if(n.left==null && n.right==null)
			{
				if(currLevel!=-1 && currLevel!=i)
					return false;
				else{
					currLevel=i;
				}
			}
			return checkLeafUtil(n.left, i+1) && checkLeafUtil(n.right, i+1);
		}
		return true;
	}

}

