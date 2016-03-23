package appleInterview;

public class _DS_BT_05InOrderWithoutRecursionStack {
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
		inOrderTraversal(n);
	}
	private static void inOrderTraversal(Node n) {
		Node current=n;
		Node curr;
		while(current!=null)
		{
			if(current.left==null)
			{
				System.out.println(current.value);
				current=current.right;
			}
			else{
				curr=current.left;
				while(curr!=curr.right && curr.right!=null)
				{
					curr=curr.right;
				}
				if(curr.right == null)
				{
					curr.right = current;
					current = current.left;
				}
				else 
				{
					curr.right = null;
					System.out.println(current.value);
					current = current.right;      
				} 
			}
		}




	}
}

