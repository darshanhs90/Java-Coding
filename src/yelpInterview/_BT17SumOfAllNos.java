package yelpInterview;

import java.util.Arrays;

public class _BT17SumOfAllNos {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(5);
		n.left=new Node(7);
		n.right=new Node(2);
		n.left.left=new Node(3);
		n.left.right=new Node(5);
		n.right.left=new Node(1);
		n.right.right=new Node(3);
		findSum(n,path,0);
		System.out.println(sum);
	}
	static int sum=0;
	private static  void findSum(Node n, int[] path, int i) {
		if(n!=null)
		{
			path[i]=n.value;
			if(n.left==null && n.right==null)
			{
				int arr[]=Arrays.copyOf(path, i+1);
				StringBuilder sb=new StringBuilder();
				for (int j = 0; j < arr.length; j++) {
					sb.append(arr[j]);
				}
				sum+=Integer.parseInt(sb.toString());
			}
			findSum(n.left, path, i+1);
			findSum(n.right, path, i+1);
		}
	}
	static int[] path=new int[100];


}

