package appleInterview;

public class _DS_LL_03SwapNodesDataLL {

	static class Node{
		Node next;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node n=new Node(1);
		n.next=new Node(2);
		n.next.next=new Node(3);
		n.next.next.next=new Node(4);
		n.next.next.next.next=new Node(5);
		//n.next.next.next.next.next=new Node(6);
		print(n);
		swapNodes(n);
		print(n);

	}
	private static void swapNodes(Node n) {
		while(n!=null)
		{
			if(n.next!=null)
			{
				n.value=n.value^n.next.value;
				n.next.value=n.value^n.next.value;
				n.value=n.value^n.next.value;
				n=n.next.next;
			}
			else{
				return;
			}
		}
	}
	private static void print(Node n) {
		while(n!=null){
			System.out.print(n.value+"/");
			n=n.next;
		}
		System.out.println();
	}

}
