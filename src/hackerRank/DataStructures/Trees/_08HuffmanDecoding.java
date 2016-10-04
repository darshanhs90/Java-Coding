package hackerRank.DataStructures.Trees;

/*
 * Link:https://www.hackerrank.com/challenges/tree-level-order-traversal
 */

public class _08HuffmanDecoding {
	static class Node{
		public  int frequency; // the frequency of this tree
		public  char data;
		public  Node left, right;
		public Node(char data) {
			this.data=data;
		}
	}
	static void decode(String S ,Node root)
	{
		StringBuilder sb=new StringBuilder();
		Node rootNode=root;
		Node currNode=root;
		for (int i = 0; i < S.length(); i++) {
			if(S.charAt(i)=='1')
			{
				//go right
				if(currNode.right!=null)
				{
					currNode=currNode.right;
				}
				else{
					sb.append(currNode.data);
					currNode=rootNode.right;
				}
			}
			else{
				//go left
				if(currNode.left!=null)
				{
					currNode=currNode.left;
				}
				else{
					sb.append(currNode.data);
					currNode=rootNode.left;
				}
			}
		}
		if(currNode!=null &&currNode.left==null && currNode.right==null)
			sb.append(currNode.data);
		S=sb.toString();
		System.out.println(sb.toString());
	}
	public static void main(String[] args) {
		Node n=new Node('#');
		n.left=new Node('#');
		n.left.left=new Node('B');
		n.left.right=new Node('C');
		n.right=new Node('A');
		decode("1001011", n);
	}

}
