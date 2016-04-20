package yelpInterview;

public class _LL24IdenticalLL {
	static class Node{
		int value;
		Node next;
		public Node(int value) {
			this.value=value;
		}
	}

	public static void main(String a[]){

		Node n=new Node(0);
		n.next=new Node(1);
		n.next.next=new Node(2);
		n.next.next.next=new Node(3);
		n.next.next.next.next=new Node(4);
		Node n1=new Node(0);
		n1.next=new Node(1);
		n1.next.next=new Node(2);
		n1.next.next.next=new Node(3);
		n1.next.next.next.next=new Node(4);
		System.out.println(findIdenticalRecursive(n,n1));
		System.out.println(findIdentical(n,n1));

		print(n);
	}









	private static boolean findIdenticalRecursive(Node n1, Node n2) {
		if(n1==null && n2==null){
			return true;
		}
		if((n1==null || n2==null)){
			return false;
		}
		return n1.value==n2.value && findIdenticalRecursive(n1.next, n2.next);
	}


	private static boolean findIdentical(Node n1, Node n2) {
		while(n1!=null && n2!=null)
		{
			if(n1.value!=n2.value)
				return false;
			n1=n1.next;
			n2=n2.next;
		}
		if(n1!=null || n2!=null)
			return false;
		return true;
	}







	private static void print(Node n) {
		while(n!=null)
		{
			System.out.print(n.value+"/");
			n=n.next;
		}
	}

}






