package appleInterview;

public class _DS_BT_13ChangeTreeToSumTree {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node n=new Node(50);
		n.left=new Node(7);
		n.right=new Node(2);
		n.left.left=new Node(3);
		n.left.right=new Node(5);
		n.right.left=new Node(1);
		n.right.right=new Node(30);
		preOrder(n);System.out.println();
		convertTree(n);
		preOrder(n);
	}
	private static void convertTree(Node tn) {
		if(tn!=null)
		{	
			if(tn.left==null && tn.right==null)
				return;
			convertTree(tn.left);
			convertTree(tn.right);
			int leftVal=0,rightVal=0;
			if(tn.left!=null)leftVal=tn.left.value;
			if(tn.right!=null)rightVal=tn.right.value;
			int diff=-tn.value+(leftVal+rightVal);
			if(diff>0){
				tn.value=tn.value+diff;
			}
			if(diff<0)
			{
				increment(tn,-diff);
			}
		}
	}
	private static void increment(Node tn, int i) {
		if(tn.left!=null)
		{
			tn.left.value+=i;
			increment(tn.left,i);  
		}
		else if (tn.right!=null) 
		{
			tn.right.value+=i;
			increment(tn.right,i);  
		}

	}
	private static void preOrder(Node n) {
		if(n!=null)
		{
			preOrder(n.left);
			System.out.print(n.value+"/");
			preOrder(n.right);
		}
	}
}

