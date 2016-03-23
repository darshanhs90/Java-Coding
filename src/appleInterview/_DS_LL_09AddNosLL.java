package appleInterview;

import java.math.BigInteger;

public class _DS_LL_09AddNosLL {
	static Node head;
	static class Node{
		Node next;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node head = new Node(5);
		head.next = new Node(6);
		head.next.next = new Node(3);
		Node head1 = new Node(8);
		head1.next = new Node(4);
		head1.next.next = new Node(2);
		head=addNos(head,head1);
		print(head);
		head = new Node(7);
		head.next = new Node(5);
		head.next.next = new Node(9);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(6);
		head1 = new Node(8);
		head1.next = new Node(4);
		head=addNos(head,head1);
		print(head);
	}


	private static Node addNos(Node n1, Node n2) {
		BigInteger b1=generateNumber(n1);
		BigInteger b2=generateNumber(n2);
		b1=b1.add(b2);
		StringBuilder sb=new StringBuilder(b1.toString());
		String str=sb.reverse().toString();
		Node n=new Node(0);
		Node pointer=n;
		for (int i = 0; i < str.length(); i++) {
			pointer.next=new Node(Integer.parseInt(str.charAt(i)+""));
			pointer=pointer.next;
		}
		return n.next;
	}


	private static BigInteger generateNumber(Node n1) {
		StringBuilder sb1=new StringBuilder("");
		while(n1!=null)
		{
			sb1.append(n1.value+"");
			n1=n1.next;
		}
		return new BigInteger(sb1.reverse().toString());
	}


	private static void print(Node n) {
		while(n!=null){
			System.out.print(n.value+"/");
			n=n.next;
		}
		System.out.println();
	}

}
