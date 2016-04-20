package yelpInterview;

public class _LL06NthNodeFromEnd {
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
		n.next.next=new Node(3);
		n.next.next.next=new Node(4);
		n.next.next.next.next=new Node(5);
		n.next.next.next.next.next=new Node(6);
		System.out.println(getNthNodeFromEnd(n,4).value);
	}

	private static Node getNthNodeFromEnd(Node n,int i) {
		Node fastPointer=n;
		int counter=0;
		while(counter!=i){
			fastPointer=fastPointer.next;
			counter++;
		}
		Node slowPointer=n;
		while(fastPointer!=null){
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next;
		}
		return slowPointer;
	}



}






