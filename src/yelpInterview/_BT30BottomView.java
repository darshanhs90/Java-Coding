package yelpInterview;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class _BT30BottomView {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(20);
		n.left=new Node(8);
		n.right=new Node(22);
		n.left.left=new Node(5);
		n.left.right=new Node(3);
		n.right.right=new Node(25);
		n.left.right.left=new Node(10);
		n.left.right.right=new Node(14);

		printTopView(n);
	}
	static TreeMap<Integer,Integer> levelMap=new TreeMap<>();
	private static void printTopView(Node n) {
		if(n!=null)
		{
			printTopViewUtil(n,0);
		}
		Map<Integer, Integer> map = levelMap;
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}
	Queue<Node> q=new LinkedList<_BT30BottomView.Node>();
	private static void printTopViewUtil(Node n, int i) {//use queue and change Node class
		if(n!=null){
			levelMap.put(i, n.value);
			printTopViewUtil(n.left,i-1);
			printTopViewUtil(n.right,i+1);
		}
	}


}

