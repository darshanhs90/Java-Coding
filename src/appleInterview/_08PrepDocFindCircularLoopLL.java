package appleInterview;

public class _08PrepDocFindCircularLoopLL {
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
		//head.next.next.next.next.next = head.next.next;
		System.out.println(hasLoop(head));
	}
	private static boolean hasLoop(Node head) {
		Node fastPointer=head;
		Node slowPointer=head;
		while(fastPointer!=null){
			fastPointer=fastPointer.next;
			if(fastPointer==null)
				break;
			fastPointer=fastPointer.next;
			slowPointer=slowPointer.next;
			if(fastPointer==slowPointer)
				break;
		}
		return fastPointer!=null;
	}
}
