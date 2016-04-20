package yelpInterview;

public class _LL04GetNthNodeLL {
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
		System.out.println(getNthNode(n,4).value);
	}

	private static Node getNthNode(Node n, int i) {
		int count=1;
		while(i!=count){
			n=n.next;
			count++;
		}
		return n;
	}



}






