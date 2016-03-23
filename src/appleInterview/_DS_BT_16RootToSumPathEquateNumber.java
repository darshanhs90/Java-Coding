package appleInterview;

public class _DS_BT_16RootToSumPathEquateNumber {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	int path[]=new int[1000];
	public static void main(String[] args) {
		Node root=new Node(10);
		root.left=new Node(8);
		root.right=new Node(2);
		root.left.left=new Node(3);
		root.left.right=new Node(5);
		root.right.left=new Node(2);
		System.out.println(findSumPath(root,21));
	}
	private static boolean findSumPath(Node root, int sum) {
		if(root!=null)
		{
			if(root.left==null && root.right==null)
			{
				return Math.abs(sum-root.value)==0;
			}
			sum=sum-root.value;
			return findSumPath(root.left, sum)||findSumPath(root.right, sum);
		}
		return false;
	}



}

