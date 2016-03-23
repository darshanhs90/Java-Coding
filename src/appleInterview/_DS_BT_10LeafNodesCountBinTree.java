package appleInterview;

public class _DS_BT_10LeafNodesCountBinTree {
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
		System.out.println(countLeafNodes(n));
	}
	private static int countLeafNodes(Node n) {
		if(n!=null)
		{
			if(n.left==null && n.right==null)
			{
				return 1;
			}
			else
				return countLeafNodes(n.left)+countLeafNodes(n.right);
		}
		return 0;
	}

}

