package yelpInterview;

public class _BT34DifferenceBetweenLevelsSum {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(5);
		n.left=new Node(2);
		n.right=new Node(6);
		n.left.left=new Node(1);
		n.left.right=new Node(4);
		n.right.right=new Node(8);
		n.left.right.left=new Node(3);
		n.right.right.left=new Node(7);
		n.right.right.right=new Node(9);
		System.out.println(findDifference(n));
	}
	private static int findDifference(Node n) {
		int sum=0;
		for (int i = 0; i < getHeight(n); i++) {
			sum+=i%2==0?getSum(n,i):-1*getSum(n,i);
		}
		return sum;
	}
	private static int getSum(Node n, int i) {
		if(n!=null)
		{
			if(i==0)
				return n.value;
			else
				return getSum(n.left, i-1)+getSum(n.right, i-1);
		}
		return 0;
	}
	private static int getHeight(Node n) {
		return n!=null?1+Math.max(getHeight(n.left), getHeight(n.right)):0;
	}

}

