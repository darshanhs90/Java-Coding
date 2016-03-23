package appleInterview;

public class _DS_LL_10RotateLL {
	static Node head;
	static class Node{
		Node next;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		print(head);
		head=rotateLL(head,2);
		print(head);
	}


	private static Node rotateLL(Node head2, int i) {
		Node mainHead=head2;
		int length=findLength(head2);
		for (int j = 0; j < i; j++) {
			Node pointer=mainHead;
			Node tempPointer=pointer;
			for (int k = 0; k < length-2; k++) {
				pointer=pointer.next;
			}
			mainHead=pointer.next;
			mainHead.next=tempPointer;
			pointer.next=null;
		}
		return mainHead;
	}


	private static int findLength(Node head2) {
		int length=0;
		while(head2!=null){
			length++;
			head2=head2.next;
		}
		return length;
	}


	private static void print(Node n) {
		while(n!=null){
			System.out.print(n.value+"/");
			n=n.next;
		}
		System.out.println();
	}

}
