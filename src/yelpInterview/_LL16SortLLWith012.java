package yelpInterview;

public class _LL16SortLLWith012 {
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
		n.next.next.next=new Node(2);
		n.next.next.next.next=new Node(1);
		n.next.next.next.next.next=new Node(1);
		n.next.next.next.next.next.next=new Node(2);
		n.next.next.next.next.next.next.next=new Node(1);
		n.next.next.next.next.next.next.next.next=new Node(2);
		n=sort(n);
		print(n);
	}


	private static Node sort(Node n) {
		Node outputNode=n;

		int onesCount=0,twosCount=0,zeroesCount=0;
		while(n!=null){
			if(n.value==0)
			{
				zeroesCount++;
			}
			else if(n.value==1){
				onesCount++;
			}else{
				twosCount++;
			}
			n=n.next;
		}
		int counter=0;
		n=outputNode;
		while(n!=null)
		{
			if(zeroesCount>0)
			{
				n.value=0;
				zeroesCount--;
			}else if(onesCount>0)
			{
				n.value=1;
				onesCount--;
			}
			else if(twosCount>0){
				n.value=2;
				twosCount--;
			}
			n=n.next;
		}
		return outputNode;
	}


	private static void print(Node n) {
		while(n!=null)
		{
			System.out.println(n.value);
			n=n.next;
		}
	}

}






