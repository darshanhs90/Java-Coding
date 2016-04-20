package yelpInterview;

public class _LL23AlternateSplitOfLL {
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
		n.next.next=new Node(0);
		n.next.next.next=new Node(1);
		n.next.next.next.next=new Node(0);
		n.next.next.next.next.next=new Node(1);
		n.next.next.next.next.next.next=new Node(0);
		n.next.next.next.next.next.next.next=new Node(1);
		alterNateSplit(n);
		//print(n);
	}






	private static void alterNateSplit(Node n) {
		Node n1=new Node(-1);
		Node n2=new Node(-1);
		Node n1Ptr=n1;
		Node n2Ptr=n2;
		boolean flag=false;
		while(n!=null)
		{
			if(flag)
			{
				n1.next=new Node(n.value);
				n1=n1.next;
			}
			else{
				n2.next=new Node(n.value);
				n2=n2.next;
			}
			flag=!flag;
			n=n.next;
		}
		n1Ptr=n1Ptr.next;
		n2Ptr=n2Ptr.next;
		print(n1Ptr);
		System.out.println();
		print(n2Ptr);
	}






	private static void print(Node n) {
		while(n!=null)
		{
			System.out.print(n.value+"/");
			n=n.next;
		}
	}

}






