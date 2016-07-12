package servicenowPrep;

public class _012DeleteFromAccess {

	static class ListNode{
		int value;
		ListNode next;
		public ListNode(int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(2);
		ListNode temp=ln.next;
		ln.value=temp.value;
		ln.next=temp.next;
	}

	


}
