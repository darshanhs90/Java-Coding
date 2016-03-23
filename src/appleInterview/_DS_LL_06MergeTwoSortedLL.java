package appleInterview;

public class _DS_LL_06MergeTwoSortedLL {
	static Node head;
	static class Node{
		Node next;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node n1=new Node(5);
		n1.next=new Node(10);
		n1.next.next=new Node(15);
		Node n2=new Node(2);
		n2.next=new Node(3);
		n2.next.next=new Node(30);
		//n1=mergeLocal(n1,n2);
		//print(n1);

		/*
		 * Recursive code below
		 */
		head=new Node(0);
		Node pointer=head;
		mergeRecursive(n1,n2);
		print(pointer.next);
	}


	private static void mergeRecursive(Node n1, Node n2) {
		if(n1!=null && n2!=null)
		{
			if(n1.value>n2.value)
			{
				head.next=new Node(n2.value);
				head=head.next;
				mergeRecursive(n1, n2.next);
			}
			else{
				head.next=new Node(n1.value);
				head=head.next;
				mergeRecursive(n1.next, n2);
			}
		}
		else{
			head.next=(n1==null)?n2:n1;
		}
	}


	private static Node mergeLocal(Node n1, Node n2) {
		Node n=new Node(0);
		Node pointer=n;
		while(n1!=null && n2!=null)
		{
			if(n1.value>n2.value){
				pointer.next=new Node(n2.value);
				n2=n2.next;
			}
			else{
				pointer.next=new Node(n1.value);
				n1=n1.next;
			}
			pointer=pointer.next;
		}
		if(n1==null)
			pointer.next=n2;
		else if(n2==null)
			pointer.next=n1;
		return n.next;
	}


	private static void print(Node n) {
		while(n!=null){
			System.out.print(n.value+"/");
			n=n.next;
		}
		System.out.println();
	}

}
