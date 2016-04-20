package yelpInterview;

public class _LL09DetectLoopLL {
	static class Node{
		int value;
		Node next;
		public Node(int value) {
			this.value=value;
		}
	}

	public static void main(String a[]){
		Node n=new Node(1);
		n.next=new Node(2);
		n.next.next=new Node(1);
		n.next.next.next=new Node(4);
		n.next.next.next.next=new Node(1);
		n.next.next.next.next.next=new Node(6);
		n.next.next.next.next = n;
		System.out.println(detectLoop(n));
	}

	private static boolean detectLoop(Node n) {
		Node fastPointer=n;
		Node slowPointer=n;
		while(fastPointer!=null)
		{
			fastPointer=fastPointer.next;
			if(fastPointer==null)
				return false;
			fastPointer=fastPointer.next;
			slowPointer=slowPointer.next;
			if(fastPointer==slowPointer)
				return true;
		}
		return false;
	}

}






