package yelpInterview;

public class _BT20DistanceBetweenTwoNodes {
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
		System.out.println(findDistance(n,4,5));
		System.out.println(findDistance(n,4,6));
		System.out.println(findDistance(n,3,4));
		System.out.println(findDistance(n,2,4));
		System.out.println(findDistance(n,8,5));
	}
	static int dist1=0,dist2=0,lcaDist=0,dist=0;
	private static int findDistance(Node n, int i, int j) {
		if(n!=null)
		{
			findRootDistance(n,0, i);
			dist1=dist;
			findRootDistance(n,0,j);
			dist2=dist;
			Node lca=findLCA(n,i,j);
			findRootDistance(n,0,lca.value);
			lcaDist=dist;
			return dist1+dist2-2*lcaDist;
		}
		return 0;
	}
	private static Node findLCA(Node n, int i, int j) {
		if(n!=null)
		{
			if(n.value==i||n.value==j)
				return n;
			Node leftNode=findLCA(n.left, i, j);
			Node rightNode=findLCA(n.right, i, j);
			if(leftNode!=null && rightNode!=null)
				return n;
			return leftNode!=null?leftNode:rightNode;
		}
		return n;
	}
	static int[]path=new int[10];
	private static void findRootDistance(Node n,int level, int i) {
		if(n!=null)
		{
			path[level]=n.value;
			if(n.value==i)
			{
				dist=level;
			}
			findRootDistance(n.left, level+1, i);
			findRootDistance(n.right, level+1, i);
		}
	}


}

