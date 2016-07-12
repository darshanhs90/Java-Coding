package servicenowPrep;

public class _008SwapNodesInLinkedList {

	static class ListNode{
		int value;
		ListNode next;
		public ListNode(int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(10);
		ln.next=new ListNode(15);
		ln.next.next=new ListNode(12);
		ln.next.next.next=new ListNode(13);
		ln.next.next.next.next=new ListNode(20);
		ln.next.next.next.next.next=new ListNode(14);
		printNodes(ln);
		//ln=(swapNodes(ln,12,20));
		//ln=(swapNodes(ln,10,20));
		ln=(swapNodes(ln,12,13));
		printNodes(ln);
	}

	private static void printNodes(ListNode ln) {
		while(ln!=null)
		{
			System.out.print(ln.value+"/");
			ln=ln.next;
		}
		System.out.println();
	}

	private static ListNode swapNodes(ListNode ln, int i, int j) {
		ListNode pointer1=ln,pointer2=ln;
		ListNode prevX=null,currX=pointer1;
		ListNode prevY=null,currY=pointer2;
		while(pointer1!=null && pointer1.value!=i){
			prevX=currX;
			currX=pointer1.next;
			pointer1=pointer1.next;
		}
		while(pointer2!=null && pointer2.value!=j){
			prevY=currY;
			currY=pointer2.next;
			pointer2=pointer2.next;
		}

		if(prevX!=null)
		{
			prevX.next=currY;
		}
		else{
			ln=currY;
		}

		if(prevY!=null)
		{
			prevY.next=currX;
		}
		else{
			ln=currX;
		}
		ListNode temp=currX.next;
		currX.next=currY.next;
		currY.next=temp;
		return ln;
	}




}
