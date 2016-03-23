package appleInterview;

public class _DS_BT_21GetLevelOfBinaryNode {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		System.out.println(getLevel(root,1));
		System.out.println(getLevel(root,2));
		System.out.println(getLevel(root,3));
		System.out.println(getLevel(root,4));
		System.out.println(getLevel(root,5));
	}
	private static int getLevel(Node n,int i) {
		int height=getHeight(n);
		for (int j = 0; j < height; j++) {
			if(printLevel(n,j,i))
				return j+1;
		}
		return -1;
	}
	private static boolean printLevel(Node tn, int level, int nodevalue) {
		if(tn!=null){
			if(level==0 && tn.value==nodevalue)
				return true;
			else
				return printLevel(tn.left, level-1, nodevalue)||printLevel(tn.right, level-1, nodevalue);
		}
		return false;
	}
	private static int getHeight(Node n) {
		return n==null?0:1+Math.max(getHeight(n.left), getHeight(n.right));
	}



}

