package yelpInterview;

public class _BST22CountBSTSubTrees{
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=insert(null,10);
		insert(n,5);
		insert(n,50);
		insert(n,1);
		insert(n,40);
		insert(n,100);
		inOrderTraversal(n);
		System.out.println();
		System.out.println(findSubTreeCount(n,5,45));
		System.out.println(findSubTreeCount(n,1,45));
	}







	private static int findSubTreeCount(Node n, int i, int j) {
		if(n!=null)
		{
			return findSubTreeCountUtil(n, i, j);
		}
		return 0;
	}







	private static int findSubTreeCountUtil(Node n, int min, int max) {
		if(n!=null)
		{
			int value=getNodes(n,min,max)==getSize(n)?1:0;
			return value+findSubTreeCountUtil(n.left,min,max)+findSubTreeCountUtil(n.right, min, max);

		}
		return 0;
	}

	private static int getSize(Node n) {
		if(n!=null)
		{
			return 1+getSize(n.left)+getSize(n.right);
		}
		return 0;
	}


	private static int getNodes(Node n, int min, int max) {
		if(n!=null)
		{
			if(n.value>=min && n.value<=max)
			{
				return 1+getNodes(n.left, min, max)+getNodes(n.right, min, max);
			}
			else if(n.value>max)
				return getNodes(n.left, min, max);
			else
				return getNodes(n.right, min, max);
		}
		return 0;
	}







	private static void inOrderTraversal(Node n) {
		if(n!=null)
		{
			inOrderTraversal(n.left);
			System.out.print(n.value+" ");
			inOrderTraversal(n.right);
		}
	}

	private static Node insert(Node n, int value) {
		if(n==null)
			return new Node(value);
		if(n.value>value)
		{//move left
			n.left=insert(n.left,value);
		}
		else{//move right
			n.right=insert(n.right,value);			
		}
		return n;
	}

}