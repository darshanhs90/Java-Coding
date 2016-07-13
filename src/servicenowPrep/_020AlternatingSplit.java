package servicenowPrep;

public class _020AlternatingSplit {

	static class ListNode{
		int value;
		ListNode next;
		public ListNode(int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(0);
		ln.next=new ListNode(1);
		ln.next.next=new ListNode(0);
		ln.next.next.next=new ListNode(1);
		ln.next.next.next.next=new ListNode(0);
		ListNode lnArr[]=alternateSplit(ln);
		ln=lnArr[0];
		while(ln!=null)
		{
			System.out.println(ln.value);ln=ln.next;
		}
		ln=lnArr[1];
		while(ln!=null)
		{
			System.out.println(ln.value);ln=ln.next;
		}
	}

	private static ListNode[] alternateSplit(ListNode ln) {
		ListNode pointer1=new ListNode(-1);
		ListNode pointer2=new ListNode(-1);
		ListNode output1=pointer1,output2=pointer2;
		boolean b=true;
		while(ln!=null)
		{	
			if(b){
				pointer1.next=new ListNode(ln.value);
				pointer1=pointer1.next;
			}
			else{
				pointer2.next=new ListNode(ln.value);
				pointer2=pointer2.next;
			}
			b=!b;ln=ln.next;
		}
		return new ListNode[]{output1.next,output2.next};
	}


}
