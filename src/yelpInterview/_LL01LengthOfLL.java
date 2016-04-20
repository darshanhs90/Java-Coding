package yelpInterview;

public class _LL01LengthOfLL {
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
		System.out.println(findIterativeLength(n));
		System.out.println(findRecursiveLength(n));
	}

	private static int findIterativeLength(Node n) {
		int count=0;
		while(n!=null){
			count++;
			n=n.next;
		}
		return count;
	}

	private static int findRecursiveLength(Node n) {
		if(n==null)
			return 0;
		return 1+findRecursiveLength(n.next);
	}


}






