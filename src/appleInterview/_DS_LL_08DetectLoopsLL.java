package appleInterview;

public class _DS_LL_08DetectLoopsLL {
	static Node head;
	static class Node{
		Node next;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node head = new Node(50);
		head.next = new Node(20);
		head.next.next = new Node(15);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(10);
		head.next.next.next.next.next = head.next.next;
		//System.out.println(startPointLoop(head));
		removeLoop(head);
		print(head);
	}

	private static Node removeLoop(Node head2) {
		Node n=startPointLoop(head2);
		System.out.println(n.value);
		Node pointer=n;
		while(pointer.next!=n)
		{
			pointer=pointer.next;
		}
		pointer.next=null;
		return n;
	}

	public static Node startPointLoop(Node head){
		if(!detectLoop(head))
			return null;
		Node fastPointer=head;
		Node slowPointer=head;
		while(fastPointer!=null && slowPointer!=null){
			fastPointer=fastPointer.next;
			if(fastPointer!=null)
				fastPointer=fastPointer.next;
			slowPointer=slowPointer.next;
			if(fastPointer==slowPointer)
				break;
		}
		slowPointer=head;
		while(fastPointer!=slowPointer)
		{
			fastPointer=fastPointer.next;
			slowPointer=slowPointer.next;

		}
		return slowPointer;
	}


	private static boolean detectLoop(Node head) {
		Node fastPointer=head;
		Node slowPointer=head;
		while(fastPointer!=null && slowPointer!=null){
			fastPointer=fastPointer.next;
			if(fastPointer!=null)
				fastPointer=fastPointer.next;
			slowPointer=slowPointer.next;
			if(fastPointer==slowPointer)
				return true;
		}
		return false;
	}

	private static void print(Node n) {
		while(n!=null){
			System.out.print(n.value+"/");
			n=n.next;
		}
		System.out.println();
	}

}
