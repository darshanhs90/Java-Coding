package yelpInterview;

public class _LL02SearchElementinLL {
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
		System.out.println(searchIterative(n,6));
		System.out.println(searchRecursive(n,6));
	}

	private static boolean searchIterative(Node n,int value) {
		while(n!=null){
			if(n.value==value)
				return true;
			n=n.next;
		}
		return false;
	}

	private static boolean searchRecursive(Node n,int value) {
		if(n==null)
			return false;
		if(n.value==value)
			return true;
		return searchRecursive(n.next,value);
	}


}






