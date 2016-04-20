package yelpInterview;

public class _LL14RotateLinkedList {
	static class Node{
		int value;
		Node next;
		public Node(int value) {
			this.value=value;
		}
	}

	public static void main(String a[]){
		Node n=new Node(10);
		n.next=new Node(20);
		n.next.next=new Node(30);
		n.next.next.next=new Node(40);
		n.next.next.next.next=new Node(50);
		n.next.next.next.next.next=new Node(60);
		print(n);
		n=rotate(n,4);
		print(n);
	}

	private static Node rotate(Node n, int i) {
		for (int j = 0; j <=i; j++) {
			n=rotateMethod(n);
		}
		return n;
	}

	private static Node rotateMethod(Node n) {
		Node currentHead=n;
		while(n.next!=null && n.next.next!=null)
		{
			n=n.next;
		}
		Node futureHead=n.next;
		n.next=null;
		futureHead.next=currentHead;
		return futureHead;
	}

	private static void print(Node n) {
		while(n!=null){
			System.out.print(n.value+"/");n=n.next;
		}
		System.out.println();
	}


}






