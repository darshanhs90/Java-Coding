package yelpInterview;

public class _LL18RemoveDuplicatesSortedLL {
	static class Node{
		int value;
		Node next;
		public Node(int value) {
			this.value=value;
		}
	}

	public static void main(String a[]){
		Node n=new Node(11);
		n.next=new Node(11);
		n.next.next=new Node(11);
		n.next.next.next=new Node(21);
		n.next.next.next.next=new Node(43);
		n.next.next.next.next.next=new Node(43);
		n.next.next.next.next.next.next=new Node(60);
		n=removeDuplicates(n);
		print(n);
	}

	private static Node removeDuplicates(Node n) {
		Node outputNode=n;
		while(n!=null)
		{
			if(n.next!=null && n.value==n.next.value)
			{
				n.next=n.next.next;
			}
			else
				n=n.next;
		}
		return outputNode;
	}









	private static void print(Node n) {
		while(n!=null)
		{
			System.out.print(n.value+"/");
			n=n.next;
		}
	}

}






