package yelpInterview;

public class _LL17PrintReverseLL {
	static class Node{
		int value;
		Node next;
		public Node(int value) {
			this.value=value;
		}
	}

	public static void main(String a[]){
		Node n=new Node(0);
		n.next=new Node(1);
		n.next.next=new Node(0);
		n.next.next.next=new Node(2);
		n.next.next.next.next=new Node(1);
		n.next.next.next.next.next=new Node(1);
		n.next.next.next.next.next.next=new Node(2);
		n.next.next.next.next.next.next.next=new Node(1);
		n.next.next.next.next.next.next.next.next=new Node(2);
		recursivePrint(n);
		System.out.println();
		print(n);
	}




	private static void recursivePrint(Node n) {
		if(n!=null)
		{
			recursivePrint(n.next);
			System.out.print(n.value+"/");
		}

	}




	private static void print(Node n) {
		while(n!=null)
		{
			System.out.print(n.value+"/");
			n=n.next;
		}
	}

}






