package yelpInterview;

import java.util.ArrayList;

public class _BT43ReverseAlternateLevels {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n1=new Node(1);
		n1.left=new Node(2);
		n1.right=new Node(3);
		n1.left.left=new Node(4);
		n1.left.right=new Node(5);
		n1.right.left=new Node(6);
		n1.right.right=new Node(7);
		n1.left.left.left=new Node(8);
		n1.left.right.left=new Node(9);
		n1.right.left.left=new Node(10);
		n1.right.right.left=new Node(11);
		n1.left.left.right=new Node(12);
		n1.left.right.right=new Node(13);
		n1.right.left.right=new Node(14);
		n1.right.right.right=new Node(15);
		levelOrder(n1);System.out.println();
		reverseLevels(n1);
		levelOrder(n1);System.out.println();
	}
	private static void levelOrder(Node n1) {
		if(n1!=null)
		{
			for (int i = 0; i < getHeight(n1); i++) {
				levelOrderTraversal(n1,i);
			}
		}
	}

	private static void levelOrderTraversal(Node n1, int i) {
		if(n1!=null)
		{
			if(i==0)
			{
				System.out.print(n1.value+"/");
			}
			else if(i>0)
			{
				levelOrderTraversal(n1.left, i-1);
				levelOrderTraversal(n1.right, i-1);
			}
		}

	}

	static ArrayList<Node> nodeList=new ArrayList<>();
	static ArrayList<Integer> valueList=new ArrayList<>();

	private static void reverseLevels(Node n1) {
		for (int i = 0; i < getHeight(n1); i++) {
			nodeList=new ArrayList<>();
			valueList=new ArrayList<>();
			if(i%2!=0){
				alternateLevels(n1,i);
				repopulateNodes();
			}
		}
	}
	private static void repopulateNodes() {
		for (int i = 0; i < nodeList.size(); i++) {
			Node n=nodeList.get(i);
			n.value=valueList.get(valueList.size()-1-i);
		}
	}
	private static void alternateLevels(Node n1, int i) {
		if(n1!=null)
		{
			if(i==0)
			{
				nodeList.add(n1);
				valueList.add(n1.value);
			}
			else if(i>0)
			{
				alternateLevels(n1.left, i-1);
				alternateLevels(n1.right, i-1);
			}
		}

	}
	private static int getHeight(Node n1) {
		return n1!=null?1+Math.max(getHeight(n1.left), getHeight(n1.right)):0;
	}

}

