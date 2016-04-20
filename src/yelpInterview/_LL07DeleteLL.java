package yelpInterview;

public class _LL07DeleteLL {
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
		deleteLL(n);
	}

	private static void deleteLL(Node n) {
		while(n!=null){
			Node temp=n.next;
			n=null;
			n=temp;
		}
	}



}






